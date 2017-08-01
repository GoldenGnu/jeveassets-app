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
package net.nikr.eve.jeveasset.io.local;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import net.nikr.eve.jeveasset.Program;
import net.nikr.eve.jeveasset.TestUtil;
import net.nikr.eve.jeveasset.data.ProfileData;
import net.nikr.eve.jeveasset.data.ProfileManager;
import net.nikr.eve.jeveasset.data.esi.EsiOwner;
import net.nikr.eve.jeveasset.data.eveapi.EveApiAccount;
import net.nikr.eve.jeveasset.data.eveapi.EveApiOwner;
import net.nikr.eve.jeveasset.data.evekit.EveKitOwner;
import net.nikr.eve.jeveasset.io.shared.ConverterTestOptions;
import net.nikr.eve.jeveasset.io.shared.ConverterTestOptionsGetter;
import net.nikr.eve.jeveasset.io.shared.ConverterTestUtil;
import org.junit.Test;

public class ProfileReadWriteTest extends TestUtil {

	private static final String FILENAME = "target" + File.separator + "profile_read_write_test.xml";

	@Test
	public void testNotNull() {
		test(false);
	}

	@Test
	public void testNull() {
		test(true);
	}

	private void test(boolean setNull) {
		for (ConverterTestOptions options : ConverterTestOptionsGetter.getConverterOptions()) {
			ProfileManager saveManager = new ProfileManager();
			//ESI
			saveManager.getEsiOwners().add(ConverterTestUtil.getEsiOwner(true, setNull, false, options));
			//EveAPI
			EveApiOwner saveEveApiOwner = ConverterTestUtil.getEveApiOwner(true, setNull, false, options);
			saveEveApiOwner.getParentAccount().getOwners().add(saveEveApiOwner);
			saveManager.getAccounts().add(saveEveApiOwner.getParentAccount());
			//EveKit
			saveManager.getEveKitOwners().add(ConverterTestUtil.getEveKitOwner(true, setNull, false, options));

			//Write
			ProfileWriter.save(saveManager, FILENAME);

			//Read
			ProfileManager loadManager = new ProfileManager();
			ProfileReader.load(loadManager, FILENAME);

			//Update dynamic data
			ProfileData profileData = new ProfileData(loadManager);
			profileData.updateEventLists();

			//ESI
			assertEquals(loadManager.getEsiOwners().size(), 1);
			EsiOwner esiOwner = loadManager.getEsiOwners().get(0);
			ConverterTestUtil.testOwner(esiOwner, setNull, options);
			//EveAPI
			assertEquals(loadManager.getAccounts().size(), 1);
			EveApiAccount loadEveApiAccount = loadManager.getAccounts().get(0);
			ConverterTestUtil.testValues(loadEveApiAccount, options);
			assertEquals(loadEveApiAccount.getOwners().size(), 1);
			EveApiOwner eveApiOwner = loadEveApiAccount.getOwners().get(0);
			ConverterTestUtil.testOwner(eveApiOwner, setNull, options);
			//EveKit
			assertEquals(loadManager.getEveKitOwners().size(), 1);
			EveKitOwner eveKitOwner = loadManager.getEveKitOwners().get(0);
			ConverterTestUtil.testOwner(eveKitOwner, setNull, options);

			//Clean up
			File file = new File(FILENAME);
			assertTrue(file.delete());

			File backupFile = new File(FILENAME.substring(0, FILENAME.lastIndexOf(".")) + "_" + Program.PROGRAM_VERSION + ".backup");
			assertTrue(backupFile.delete());
		}
	}

}
