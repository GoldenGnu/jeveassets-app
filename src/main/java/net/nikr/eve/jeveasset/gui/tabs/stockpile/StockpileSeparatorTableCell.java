/* Glazed Lists                                                 (c) 2003-2006 */
/* http://publicobject.com/glazedlists/                      publicobject.com,*/
/*                                                     O'Dell Engineering Ltd.*/

package net.nikr.eve.jeveasset.gui.tabs.stockpile;

import ca.odell.glazedlists.SeparatorList;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import net.nikr.eve.jeveasset.Program;
import net.nikr.eve.jeveasset.gui.images.Images;
import net.nikr.eve.jeveasset.gui.shared.components.JDropDownButton;
import net.nikr.eve.jeveasset.gui.shared.table.SeparatorTableCell;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileItem;
import net.nikr.eve.jeveasset.i18n.TabsStockpile;

/**
 *
 * @author <a href="mailto:jesse@swank.ca">Jesse Wilson</a>
 */
public class StockpileSeparatorTableCell extends SeparatorTableCell<StockpileItem> implements HierarchyListener, AdjustmentListener {

	public static final String ACTION_DELETE_STOCKPILE = "ACTION_DELETE_STOCKPILE";
	public static final String ACTION_EDIT_STOCKPILE = "ACTION_EDIT_STOCKPILE";
	public static final String ACTION_CLONE_STOCKPILE = "ACTION_CLONE_STOCKPILE";
	public static final String ACTION_SHOPPING_LIST_SINGLE = "ACTION_SHOPPING_LIST_SINGLE";
	public static final String ACTION_ADD_ITEM = "ACTION_ADD_ITEM";

	private final JLabel jStartSpace;
	private final JLabel jGroup;
	private final JLabel jColor;
	private final JLabel jColorDisabled;
	private final JDropDownButton jStockpile;
	private final JLabel jOwnerLabel;
	private final JLabel jOwner;
	private final JLabel jLocation;
	private final JLabel jLocationLabel;
	private Program program;

	public StockpileSeparatorTableCell(final Program program, final JTable jTable, final SeparatorList<StockpileItem> separatorList, final ActionListener actionListener) {
		super(jTable, separatorList);
		this.program = program;

		jTable.addHierarchyListener(this);

		jStartSpace = new JLabel();

		jColor = new JLabel();
		jColor.setOpaque(true);
		jColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		jColorDisabled = new JLabel();
		jColorDisabled.setOpaque(false);
		jColorDisabled.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		jColorDisabled.setVisible(false);

		jGroup = new JLabel();
		jGroup.setBorder(null);
		jGroup.setOpaque(false);
		jGroup.setFont(new Font(jGroup.getFont().getName(), Font.BOLD, jGroup.getFont().getSize() + 1));

		Color color = Color.BLACK;

		//Owner
		jOwnerLabel = new JLabel(TabsStockpile.get().stockpileOwner());
		jOwnerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		jOwnerLabel.setForeground(color);
		jOwnerLabel.setFont(new Font(jOwnerLabel.getFont().getName(), Font.BOLD, jOwnerLabel.getFont().getSize()));

		jOwner = new JLabel();
		jOwner.setVerticalAlignment(SwingConstants.BOTTOM);
		jOwner.setForeground(color);

		//Location
		jLocationLabel = new JLabel(TabsStockpile.get().stockpileLocation());
		jLocationLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		jLocationLabel.setForeground(color);
		jLocationLabel.setFont(new Font(jLocationLabel.getFont().getName(), Font.BOLD, jLocationLabel.getFont().getSize()));

		jLocation = new JLabel();
		jLocation.setForeground(color);
		jLocation.setVerticalAlignment(SwingConstants.BOTTOM);

		//Stockpile Edit/Add/etc.
		jStockpile = new JDropDownButton(TabsStockpile.get().stockpile());
		jStockpile.setOpaque(false);

		JMenuItem jMenuItem;

		JMenuItem jAdd = new JMenuItem(TabsStockpile.get().addItem(), Images.EDIT_ADD.getIcon());
		jAdd.setActionCommand(ACTION_ADD_ITEM);
		jAdd.addActionListener(actionListener);
		jStockpile.add(jAdd);

		jStockpile.addSeparator();

		jMenuItem = new JMenuItem(TabsStockpile.get().editStockpile(), Images.EDIT_EDIT.getIcon());
		jMenuItem.setActionCommand(ACTION_EDIT_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);

		jMenuItem = new JMenuItem(TabsStockpile.get().cloneStockpile(), Images.EDIT_COPY.getIcon());
		jMenuItem.setActionCommand(ACTION_CLONE_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);

		jMenuItem = new JMenuItem(TabsStockpile.get().deleteStockpile(), Images.EDIT_DELETE.getIcon());
		jMenuItem.setActionCommand(ACTION_DELETE_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);

		jStockpile.addSeparator();

		jMenuItem = new JMenuItem(TabsStockpile.get().getShoppingList(), Images.STOCKPILE_SHOPPING_LIST.getIcon());
		jMenuItem.setActionCommand(ACTION_SHOPPING_LIST_SINGLE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);

		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(jStartSpace)
					.addComponent(jExpand)
					.addGap(5)
					.addComponent(jColor, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6)
					.addComponent(jColorDisabled, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6)
					.addGap(10)
					.addComponent(jStockpile, Program.BUTTONS_WIDTH, Program.BUTTONS_WIDTH, Program.BUTTONS_WIDTH)
					.addGap(10)
					.addComponent(jGroup, 150, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jOwnerLabel)
					.addGap(5)
					.addComponent(jOwner, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jLocationLabel)
					.addGap(5)
					.addComponent(jLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGap(2)
				.addGroup(layout.createParallelGroup()
					.addComponent(jStartSpace, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addComponent(jExpand, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addGroup(layout.createSequentialGroup()
						.addGap(3)
						.addComponent(jColor, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6)
						.addComponent(jColorDisabled, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6, Program.BUTTONS_HEIGHT - 6)
					)
					.addComponent(jStockpile, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addComponent(jGroup, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addGroup(layout.createSequentialGroup()
						.addGap(4)
						.addGroup(layout.createParallelGroup()
							.addComponent(jLocationLabel)
							.addComponent(jLocation)
							.addComponent(jOwnerLabel)
							.addComponent(jOwner)
						)
					)
				)
				.addGap(2)
		);
	}

	private void setEnabled(final boolean aFlag) {
		jGroup.setEnabled(aFlag);
		jColor.setVisible(aFlag);
		jColorDisabled.setVisible(!aFlag);
		jStockpile.setEnabled(aFlag);
		jOwnerLabel.setEnabled(aFlag);
		jOwner.setEnabled(aFlag);
		jLocation.setEnabled(aFlag);
		jLocationLabel.setEnabled(aFlag);
		jExpand.setEnabled(aFlag);
	}

	@Override
	protected void configure(final SeparatorList.Separator<?> separator) {
		StockpileItem stockpileItem = (StockpileItem) separator.first();
		if (stockpileItem == null) { // handle 'late' rendering calls after this separator is invalid
			return;
		}
		jGroup.setText(stockpileItem.getStockpile().getName());
		if (stockpileItem.getStockpile().isOK()) {
			jColor.setBackground(new Color(200, 255, 200));
		} else if (stockpileItem.getStockpile().isHalf() && program.getSettings().isStockpileHalfColors()) {
			jColor.setBackground(new Color(255, 255, 200));
		} else {
			jColor.setBackground(new Color(255, 200, 200));
		}
		String location = stockpileItem.getStockpile().getLocation();
		jLocation.setText(location);
		jLocation.setToolTipText(location);
		jLocationLabel.setToolTipText(location);
		String owner = stockpileItem.getStockpile().getOwner();
		jOwner.setText(owner);
		jOwner.setToolTipText(owner);
		jOwnerLabel.setToolTipText(owner);
	}

	protected JViewport getParentViewport() {
		Container container = jTable.getParent();
		if (container instanceof JViewport) {
			return (JViewport) container;
		} else {
			return null;
		}
	}

	@Override
	public void hierarchyChanged(final HierarchyEvent e) {
		if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) == HierarchyEvent.PARENT_CHANGED) {
			JViewport jViewport = getParentViewport();
			if (jViewport != null) {
				Container container = getParentViewport().getParent();
				if (container instanceof JScrollPane) {
					JScrollPane jScroll = (JScrollPane) container;
					//jScroll.getVerticalScrollBar().removeAdjustmentListener(this);
					jScroll.getHorizontalScrollBar().removeAdjustmentListener(this);
					//jScroll.getVerticalScrollBar().addAdjustmentListener(this);
					jScroll.getHorizontalScrollBar().addAdjustmentListener(this);
				}
			}
		}
	}

	@Override
	public void adjustmentValueChanged(final AdjustmentEvent e) {
		if (!e.getValueIsAdjusting()) {
			int position = getParentViewport().getViewPosition().x;
			jStartSpace.setMinimumSize(new Dimension(position, Program.BUTTONS_HEIGHT));
			setEnabled(true);
			jTable.repaint();
		} else {
			if (jExpand.isEnabled()) { //Only do once
				setEnabled(false);
				jTable.repaint();
			}
		}
	}
}
