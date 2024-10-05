/*
 * Copyright 2009-2023 Contributors (see credits.txt)
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

package net.nikr.eve.jeveasset.i18n;

import java.util.Locale;
import uk.me.candle.translations.Bundle;

public abstract class GuiShared extends Bundle {

	public static GuiShared get() {
		return BundleServiceFactory.getBundleService().get(GuiShared.class);
	}

	public GuiShared(final Locale locale) {
		super(locale);
	}

	public abstract String adam4eve();
	public abstract String add();
	public abstract String addFilter();
	public abstract String addTransactionFilter();
	public abstract String all();
	public abstract String background();
	public abstract String cellAverage();
	public abstract String cellAverageToolTip();
	public abstract String cellInformation();
	public abstract String cellInformationToolTip();
	public abstract String cellInformationColumn();
	public abstract String cellInformationColumnToolTip();
	public abstract String cellCount();
	public abstract String cellCountToolTip();
	public abstract String cellMaximum();
	public abstract String cellMaximumToolTip();
	public abstract String cellMinimum();
	public abstract String cellMinimumToolTip();
	public abstract String cellSum();
	public abstract String cellSumToolTip();
	public abstract String checkAll();
	public abstract String chruker();
	public abstract String clickToCopyGroup();
	public abstract String clickToCopySelectionInfo();
	public abstract String clickToCopyWrap(String toolTip);
	public abstract String constellation();
	public abstract String containerDelete();
	public abstract String containerEdit();
	public abstract String containerText();
	public abstract String copy();
	public abstract String copyEveMultiBuy();
	public abstract String copyPlus();
	public abstract String custom();
	public abstract String cut();
	public abstract String delete();
	public abstract String dotlan();
	public abstract String edit();
	public abstract String emptyString();
	public abstract String errorLoadingSettingsMsg();
	public abstract String errorLoadingSettingsTitle();
	public abstract String errorLoadingProfileMsg();
	public abstract String errorLoadingProfileTitle();
	public abstract String eveCookbook();
	public abstract String eveInfo();
	public abstract String eveMissioneer();
	public abstract String eveRef();
	public abstract String eveTycoon();
	public abstract String foreground();
	public abstract String formulaColumns();
	public abstract String formulaDateToolTip();
	public abstract String formulaFunctions();
	public abstract String formulaMenu();
	public abstract String formulaName();
	public abstract String formulaOperations();
	public abstract String formulaString();
	public abstract String formulaTitle();
	public abstract String fuzzworkBlueprints();
	public abstract String fuzzworkItems();
	public abstract String fuzzworkMarket();
	public abstract String helpFilter();
	public abstract String helpSettings();
	public abstract String helpStockpile();
	public abstract String helpOpenManual(String title);
	public abstract String helpOpenManualTitle();
	public abstract String importEft();
	public abstract String importEveMultibuy();
	public abstract String importIskPerHour();
	public abstract String importOptions();
	public abstract String importOptionsMerge();
	public abstract String importOptionsOverwrite();
	public abstract String importOptionsRename();
	public abstract String importOptionsSkip();
	public abstract String importStockpilesShoppingList();
	public abstract String industry();
	public abstract String invalidMsg();
	public abstract String invalidTitle();
	public abstract String item();
	public abstract String itemDatabase();
	public abstract String itemDelete();
	public abstract String itemEdit();
	public abstract String itemNameTitle();
	public abstract String itemPriceTitle();
	public abstract String jumps();
	public abstract String jumpsAddCustom();
	public abstract String jumpsAddSelected();
	public abstract String jumpsClear();
	public abstract String jumpsColumnToolTip(String systemName);
	public abstract String lazyBlacksmith();
	public abstract String lazyBlacksmithInvention();
	public abstract String lazyBlacksmithManufacturing();
	public abstract String lazyBlacksmithResearch();
	public abstract String loadout();
	public abstract String loadoutOpen();
	public abstract String loadoutSelectShip();
	public abstract String location();
	public abstract String locationClear();
	public abstract String locationClearConfirm(String location);
	public abstract String locationClearConfirmAll(int size);
	public abstract String locationEmpty();
	public abstract String locationID();
	public abstract String locationName();
	public abstract String locationRename();
	public abstract String locationSystem();
	public abstract String lookup();
	public abstract String market();
	public abstract String newStockpile();
	public abstract String none();
	public abstract String ok();
	public abstract String openLinks(int size);
	public abstract String openLinksTitle();
	public abstract String overwrite();
	public abstract String overwriteTitle();
	public abstract String overwriteFile();
	public abstract String paste();
	public abstract String planet();
	public abstract String priceHistory();
	public abstract String region();
	public abstract String reprocessed();
	public abstract String routing();
	public abstract String selectionAverage();
	public abstract String selectionContractsBought();
	public abstract String selectionContractsBoughtToolTip();
	public abstract String selectionContractsBuying();
	public abstract String selectionContractsBuyingToolTip();
	public abstract String selectionContractsCollateralAcceptor();
	public abstract String selectionContractsCollateralAcceptorToolTip();
	public abstract String selectionContractsCollateralIssuer();
	public abstract String selectionContractsCollateralIssuerToolTip();
	public abstract String selectionContractsSellingAssets();
	public abstract String selectionContractsSellingAssetsToolTip();
	public abstract String selectionContractsSellingPrice();
	public abstract String selectionContractsSellingPriceToolTip();
	public abstract String selectionContractsSold();
	public abstract String selectionContractsSoldToolTip();
	public abstract String selectionCount();
	public abstract String selectionInventionSuccess();
	public abstract String selectionManufactureJobsValue();
	public abstract String selectionOrdersCount();
	public abstract String selectionOrdersCountValue(String volumeRemain, String volumeTotal);
	public abstract String selectionOrdersSellTotal();
	public abstract String selectionOrdersBuyTotal();
	public abstract String selectionOrdersBuyEscrow();
	public abstract String selectionOrdersBuyToCover();
	public abstract String selectionOrdersBrokersFee();
	public abstract String selectionTransactionsSellCount();
	public abstract String selectionTransactionsSellTotal();
	public abstract String selectionTransactionsSellAvg();
	public abstract String selectionTransactionsSellTax();
	public abstract String selectionTransactionsBothCount();
	public abstract String selectionTransactionsBothTotal();
	public abstract String selectionTransactionsBothAvg();
	public abstract String selectionTransactionsBuyCount();
	public abstract String selectionTransactionsBuyAvg();
	public abstract String selectionTransactionsBuyTotal();
	public abstract String selectionCopiedToClipboard();
	public abstract String selectionTitle();
	public abstract String selectionTitleBoth();
	public abstract String selectionTitleBuy();
	public abstract String selectionTitleCollateral();
	public abstract String selectionTitleNeeded();
	public abstract String selectionTitleNow();
	public abstract String selectionTitleSell();
	public abstract String selectionValue();
	public abstract String selectionValueNeeded();
	public abstract String selectionValueNow();
	public abstract String selectionValueReprocessed();
	public abstract String selectionVolume();
	public abstract String selectionVolumeNeeded();
	public abstract String selectionVolumeNow();
	public abstract String selectionShortAverage();
	public abstract String selectionShortBrokerFees();
	public abstract String selectionShortBuy();
	public abstract String selectionShortCount();
	public abstract String selectionShortEscrow();
	public abstract String selectionShortGroup(String text);
	public abstract String selectionShortInventionSuccess();
	public abstract String selectionShortIskToCover();
	public abstract String selectionShortOutputValue();
	public abstract String selectionShortReprocessedValue();
	public abstract String selectionShortSell();
	public abstract String selectionShortTax();
	public abstract String selectionShortValue();
	public abstract String selectionShortVolume();
	public abstract String selectionSlotsContractCharacter();
	public abstract String selectionSlotsContractCharacterFree();
	public abstract String selectionSlotsContractCharacterActive();
	public abstract String selectionSlotsContractCharacterMax();
	public abstract String selectionSlotsContractCharacterFreeToolTip();
	public abstract String selectionSlotsContractCharacterActiveToolTip();
	public abstract String selectionSlotsContractCharacterMaxToolTip();
	public abstract String selectionSlotsContractCorporation();
	public abstract String selectionSlotsContractCorporationFree();
	public abstract String selectionSlotsContractCorporationActive();
	public abstract String selectionSlotsContractCorporationMax();
	public abstract String selectionSlotsContractCorporationFreeToolTip();
	public abstract String selectionSlotsContractCorporationActiveToolTip();
	public abstract String selectionSlotsContractCorporationMaxToolTip();
	public abstract String selectionSlotsManufacturing();
	public abstract String selectionSlotsManufacturingDone();
	public abstract String selectionSlotsManufacturingFree();
	public abstract String selectionSlotsManufacturingActive();
	public abstract String selectionSlotsManufacturingMax();
	public abstract String selectionSlotsManufacturingDoneToolTip();
	public abstract String selectionSlotsManufacturingFreeToolTip();
	public abstract String selectionSlotsManufacturingActiveToolTip();
	public abstract String selectionSlotsManufacturingMaxToolTip();
	public abstract String selectionSlotsMarketOrders();
	public abstract String selectionSlotsMarketOrdersFree();
	public abstract String selectionSlotsMarketOrdersActive();
	public abstract String selectionSlotsMarketOrdersMax();
	public abstract String selectionSlotsMarketOrdersFreeToolTip();
	public abstract String selectionSlotsMarketOrdersActiveToolTip();
	public abstract String selectionSlotsMarketOrdersMaxToolTip();
	public abstract String selectionSlotsReactions();
	public abstract String selectionSlotsReactionsDone();
	public abstract String selectionSlotsReactionsFree();
	public abstract String selectionSlotsReactionsActive();
	public abstract String selectionSlotsReactionsMax();
	public abstract String selectionSlotsReactionsDoneToolTip();
	public abstract String selectionSlotsReactionsFreeToolTip();
	public abstract String selectionSlotsReactionsActiveToolTip();
	public abstract String selectionSlotsReactionsMaxToolTip();
	public abstract String selectionSlotsResearch();
	public abstract String selectionSlotsResearchDone();
	public abstract String selectionSlotsResearchFree();
	public abstract String selectionSlotsResearchActive();
	public abstract String selectionSlotsResearchMax();
	public abstract String selectionSlotsResearchDoneToolTip();
	public abstract String selectionSlotsResearchFreeToolTip();
	public abstract String selectionSlotsResearchActiveToolTip();
	public abstract String selectionSlotsResearchMaxToolTip();
	public abstract String set();
	public abstract String station();
	public abstract String stockpile();
	public abstract String system();
	public abstract String tableColumns();
	public abstract String tableColumnsReset();
	public abstract String tableColumnsTip();
	public abstract String tableColumnsTitle();
	public abstract String tableResizeText();
	public abstract String tableResizeWindow();
	public abstract String tableResizeNone();
	public abstract String tableSettings();
	public abstract String tags();
	public abstract String tagsEditTitle();
	public abstract String tagsName(String name, Integer count);
	public abstract String tagsNew();
	public abstract String tagsNewMsg();
	public abstract String tagsNewTitle();
	public abstract String toolsUpdateTitle();
	public abstract String ui();
	public abstract String uiWaypoint();
	public abstract String uiWaypointBeginning();
	public abstract String uiWaypointClear();
	public abstract String uiWaypointFail();
	public abstract String uiWaypointOk();
	public abstract String uiWaypointTitle();
	public abstract String uiCharacterInvalidMsg();
	public abstract String uiCharacterMsg();
	public abstract String uiCharacterTitle();
	public abstract String uiContract();
	public abstract String uiContractFail();
	public abstract String uiContractOk();
	public abstract String uiContractTitle();
	public abstract String uiLocationTitle();
	public abstract String uiMarket();
	public abstract String uiMarketFail();
	public abstract String uiMarketOk();
	public abstract String uiMarketTitle();
	public abstract String uiOwner();
	public abstract String uiOwnerFail();
	public abstract String uiOwnerMsg();
	public abstract String uiOwnerOk();
	public abstract String uiOwnerTitle();
	public abstract String uiStation();
	public abstract String uiSystem();
	public abstract String unknownFaction();
	public abstract String unknownOwner();
	public abstract String updateStructures();
	public abstract String updating();
	public abstract String zKillboard();

	public abstract String today(Object arg0);
	public abstract String files(Object arg0);
	public abstract String deleteView();
	public abstract String deleteViews(int size);
	public abstract String editViews();
	public abstract String enterViewName();
	public abstract String loadView();
	public abstract String manageViews();
	public abstract String noViewName();
	public abstract String overwriteView();
	public abstract String renameView();
	public abstract String saveView();
	public abstract String saveViewMsg();

	//Filters
	public abstract String saveFilter();
	public abstract String saveFilterToolTip();
	public abstract String enterFilterName();
	public abstract String save();
	public abstract String cancel();
	public abstract String noFilterName();
	public abstract String overwriteDefaultFilter();
	public abstract String overwriteFilter();
	public abstract String addField();
	public abstract String addFieldToolTip();
	public abstract String clearField();
	public abstract String clearFieldToolTip();
	public abstract String loadFilter();
	public abstract String loadFilterToolTip();
	public abstract String showFilters();
	public abstract String showFiltersToolTip();
	public abstract String manageFilters();
	public abstract String nothingToSave();
	public abstract String filterManager();
	public abstract String managerExport();
	public abstract String managerImport();
	public abstract String managerImportFailMsg();
	public abstract String managerImportFailTitle();
	public abstract String managerLoad();
	public abstract String managerRename();
	public abstract String managerDelete();
	public abstract String managerClose();
	public abstract String renameFilter();
	public abstract String deleteFilter();
	public abstract String deleteFilters(int size);
	public abstract String mergeFilters();
	public abstract String managerMerge();
	public abstract String filterAll();
	public abstract String filterAnd();
	public abstract String filterOr();
	public abstract String filterContains();
	public abstract String filterContainsNot();
	public abstract String filterEquals();
	public abstract String filterEqualsNot();
	public abstract String filterRegex();
	public abstract String filterGreaterThan();
	public abstract String filterLastDays();
	public abstract String filterNextDays();
	public abstract String filterLastHours();
	public abstract String filterNextHours();
	public abstract String filterLessThan();
	public abstract String filterBefore();
	public abstract String filterAfter();
	public abstract String filterEqualsDate();
	public abstract String filterEqualsNotDate();
	public abstract String filterContainsColumn();
	public abstract String filterContainsNotColumn();
	public abstract String filterEqualsColumn();
	public abstract String filterEqualsNotColumn();
	public abstract String filterGreaterThanColumn();
	public abstract String filterLessThanColumn();
	public abstract String filterBeforeColumn();
	public abstract String filterAfterColumn();
	public abstract String filterUntitled();
	public abstract String filterEmpty();
	public abstract String filterShowing(int rowCount, int size, String filterName);
	public abstract String popupMenuAddField();
	public abstract String export();
	public abstract String exportToolTip();
	public abstract String exportTableData();

	//Text Dialog
	public abstract String textLoadFailMsg();
	public abstract String textLoadFailTitle();
	public abstract String textSaveFailMsg();
	public abstract String textSaveFailTitle();
	public abstract String textToClipboard();
	public abstract String textToFile();
	public abstract String textFromClipboard();
	public abstract String textFromFile();
	public abstract String textClose();
	public abstract String textImport();
	public abstract String textInvalid();
	public abstract String textEmpty();
	public abstract String textExport();

	//JSimpleColorPicker
	public abstract String colorDefault();
	public abstract String colorNone();
	public abstract String colorCustom();
}
