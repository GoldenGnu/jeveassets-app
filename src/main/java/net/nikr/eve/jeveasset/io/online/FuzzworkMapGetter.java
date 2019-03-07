/*
 * Copyright 2009-2018 Contributors (see credits.txt)
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
package net.nikr.eve.jeveasset.io.online;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FuzzworkMapGetter { 

	private static final Logger LOG = LoggerFactory.getLogger(FuzzworkMapGetter.class);

	public static Celestial nearestCelestialName(Integer systemID, Double x, Double y, Double z) {
        if (systemID == null || x == null || y == null || z == null) {
            return null;
        }
        try {
			StringBuilder query = new StringBuilder();
			query.append("solarsystemid=");
			query.append(systemID);
			query.append("&x=");
			query.append(x);
			query.append("&y=");
			query.append(y);
			query.append("&z=");
			query.append(z);
			URL url = new URL("https://www.fuzzwork.co.uk/api/nearestCelestial.php?" + query.toString());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
            ObjectMapper mapper = new ObjectMapper(); //create once, reuse
            Celestial result = mapper.readValue(con.getInputStream(), Celestial.class);
            if (result == null) {
                return null;
            }
            //Updated OK
			return result;
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return null;
	}

	public static List<Planet> getPlanets(Set<Integer> planetIDs) {
        if (planetIDs == null) {
            return new ArrayList<>();
        }
        try {
			List<Planet> planets = new ArrayList<>();
			for (Integer planetID : planetIDs) {
				StringBuilder query = new StringBuilder();
				query.append("itemid=");
				query.append(planetID);
				query.append("&format=json");
				URL url = new URL("https://www.fuzzwork.co.uk/api/mapdata.php?" + query.toString());
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				ObjectMapper mapper = new ObjectMapper(); //create once, reuse
				List<Planet> results = mapper.readValue(con.getInputStream(), new TypeReference<List<Planet>>() {});
				if (results != null) {
					planets.addAll(results);
				}
			}
			return planets;
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return null;
	}

	public static class Celestial {
		public String itemName;
		public int typeid;
		public long itemid;
		public double distance;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Planet { 
		public Integer itemid;
		public String itemname;
		public Integer solarsystemid;

		public Integer getSystemId() {
			return solarsystemid;
		}
		public Integer getPlanetId() {
			return itemid;
		}
		public String getName() {
			return itemname;
		}
	}
}
