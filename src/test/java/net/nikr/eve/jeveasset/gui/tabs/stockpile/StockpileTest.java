/*
 * Copyright 2009-2025 Contributors (see credits.txt)
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

package net.nikr.eve.jeveasset.gui.tabs.stockpile;

import java.util.Collections;
import net.nikr.eve.jeveasset.TestUtil;
import net.nikr.eve.jeveasset.data.sde.Item;
import net.nikr.eve.jeveasset.data.sde.MyLocation;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileFilter;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileFilter.StockpileContainer;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileFilter.StockpileFlag;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileItem;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileTotal;
import static org.junit.Assert.*;
import org.junit.Test;


public class StockpileTest extends TestUtil {

	@Test
	public void testSomeMethod() {
		StockpileFilter filter = new StockpileFilter(MyLocation.create(0),
				false, //Exclude
				Collections.singletonList(new StockpileFlag(0, true)),
				Collections.singletonList(new StockpileContainer("Container", false)),
				Collections.singletonList(0L),
				null, //JobsDaysLess
				null, //JobsDaysMore
				true, true, true, true, true, true, true, true, true, true, true);
		Stockpile stockpile = new Stockpile("Name", null, Collections.singletonList(filter), 1, false);
		StockpileItem item1 = new Stockpile.StockpileItem(stockpile, new Item(0), 0, 0, false);
		StockpileItem item2 = new Stockpile.StockpileItem(stockpile, new Item(0), 0, 0, false);
		StockpileTotal total1 = new StockpileTotal(stockpile);
		StockpileTotal total2 = new StockpileTotal(stockpile);
		assertEquals(item1.compareTo(item2), item2.compareTo(item2), 0);
		assertEquals(total1.compareTo(total2), total2.compareTo(total1), 0);
		assertEquals(0, total1.compareTo(total2), 0);
		assertEquals(0, item1.compareTo(item2), 0);
	}
}
