/*
 * Copyright 2009-2017 Contributors (see credits.txt)
 *
 * This file is part of jEveAssets.
 *
 * jEveAssets is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * jEveAssets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jEveAssets; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */
package net.nikr.eve.jeveasset.io.esi;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.nikr.eve.jeveasset.data.Citadel;
import net.nikr.eve.jeveasset.data.MyLocation;
import net.nikr.eve.jeveasset.data.api.OwnerType;
import net.nikr.eve.jeveasset.data.esi.EsiOwner;
import net.nikr.eve.jeveasset.data.raw.RawAsset;
import net.nikr.eve.jeveasset.data.raw.RawBlueprint;
import net.nikr.eve.jeveasset.data.raw.RawContract;
import net.nikr.eve.jeveasset.data.raw.RawMarketOrder;
import net.nikr.eve.jeveasset.gui.dialogs.update.UpdateTask;
import net.nikr.eve.jeveasset.gui.tabs.jobs.MyIndustryJob;
import net.nikr.eve.jeveasset.io.online.CitadelGetter;
import net.nikr.eve.jeveasset.io.shared.ApiIdConverter;
import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.StructureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsiStructuresGetter extends AbstractEsiGetter {

	private static final Logger LOG = LoggerFactory.getLogger(EsiStructuresGetter.class);

	private final Map<Long, Set<Long>> mapLocationIDs = new HashMap<Long, Set<Long>>();
	private final Map<Long, Set<Long>> mapItemIDs = new HashMap<Long, Set<Long>>();

	public void load(UpdateTask updateTask, List<EsiOwner> owners, List<OwnerType> typeOwners) {
		mapLocationIDs.clear();
		mapItemIDs.clear();
		for (EsiOwner owner : owners) {
			mapLocationIDs.put(owner.getOwnerID(), new HashSet<Long>());
			mapItemIDs.put(owner.getOwnerID(), new HashSet<Long>());
		}
		for (OwnerType owner : typeOwners) {
			Set<Long> locationIDs = mapLocationIDs.get(owner.getOwnerID());
			Set<Long> itemIDs = mapItemIDs.get(owner.getOwnerID());
			if (locationIDs != null) {
				getIDs(locationIDs, itemIDs, owner);
			}
		}
		super.load(updateTask, owners);
	}

	@Override
	protected void get(EsiOwner owner) throws ApiException {
		List<Citadel> citadels = new ArrayList<Citadel>();
		Set<Long> locationIDs = mapLocationIDs.get(owner.getOwnerID());
		Set<Long> itemIDs = mapItemIDs.get(owner.getOwnerID());
		locationIDs.removeAll(itemIDs);
		for (Long locationID : locationIDs) {
			try {
				StructureResponse response = getUniverseApiAuth().getUniverseStructuresStructureId(locationID, DATASOURCE, null, null, null);
				citadels.add(ApiIdConverter.getCitadel(response, locationID));
			} catch (ApiException ex) {
				if (ex.getCode() != 403 && ex.getCode() != 404) { //Ignore 403: Forbidden and 404: Structure not found
					throw ex;
				} else {
					LOG.info("Failed to find locationID: " + locationID);
				}
			}
		}
		CitadelGetter.set(citadels);
	}

	@Override
	protected void setNextUpdate(EsiOwner owner, Date date) {
		owner.setStructuresNextUpdate(date);
	}

	@Override
	protected Date getNextUpdate(EsiOwner owner) {
		return owner.getStructuresNextUpdate();
	}

	@Override
	protected boolean inScope(EsiOwner owner) {
		return owner.isStructures();
	}

	@Override
	protected String getTaskName() {
		return "Structures";
	}

	private void getIDs(Set<Long> locationIDs, Set<Long> itemIDs, OwnerType owner) {
		for (RawAsset asset : owner.getAssets()) {
			itemIDs.add(asset.getItemID());
			long locationID = asset.getLocationID();
			MyLocation location = ApiIdConverter.getLocation(locationID);
			if (location.isEmpty() || location.isUserLocation() || location.isCitadel()) {
				locationIDs.add(location.getLocationID());
			}
		}
		for (RawBlueprint blueprint : owner.getBlueprints().values()) {
			itemIDs.add(blueprint.getItemID());
			MyLocation location = ApiIdConverter.getLocation(blueprint.getLocationID());
			if (location.isEmpty() || location.isUserLocation() || location.isCitadel()) {
				locationIDs.add(location.getLocationID());
			}
		}
		for (RawContract contract : owner.getContracts().keySet()) {
			long locationEndID = contract.getEndLocationID();
			MyLocation locationEnd = ApiIdConverter.getLocation(locationEndID);
			if (locationEnd.isEmpty() || locationEnd.isUserLocation() || locationEnd.isCitadel()) {
				locationIDs.add(locationEnd.getLocationID());
			}
			long locationStartID = contract.getStartLocationID();
			MyLocation locationStart = ApiIdConverter.getLocation(locationStartID);
			if (locationStart.isEmpty() || locationStart.isUserLocation() || locationStart.isCitadel()) {
				locationIDs.add(locationStart.getLocationID());
			}
		}
		for (MyIndustryJob industryJob : owner.getIndustryJobs()) {
			long locationID = industryJob.getLocationID();
			MyLocation location = ApiIdConverter.getLocation(locationID);
			if (location.isEmpty() || location.isUserLocation() || location.isCitadel()) {
				locationIDs.add(location.getLocationID());
			}
		}
		for (RawMarketOrder marketOrder : owner.getMarketOrders()) {
			long locationID = marketOrder.getLocationID();
			MyLocation location = ApiIdConverter.getLocation(locationID);
			if (location.isEmpty() || location.isUserLocation() || location.isCitadel()) {
				locationIDs.add(location.getLocationID());
			}
		}
	}
}
