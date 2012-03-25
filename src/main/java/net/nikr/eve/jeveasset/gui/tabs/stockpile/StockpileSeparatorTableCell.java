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
import net.nikr.eve.jeveasset.gui.shared.JDropDownButton;
import net.nikr.eve.jeveasset.gui.shared.SeparatorTableCell;
import net.nikr.eve.jeveasset.gui.tabs.stockpile.Stockpile.StockpileItem;
import net.nikr.eve.jeveasset.i18n.TabsStockpile;

/**
 *
 * @author <a href="mailto:jesse@swank.ca">Jesse Wilson</a>
 */
public class StockpileSeparatorTableCell extends SeparatorTableCell<StockpileItem> implements HierarchyListener, AdjustmentListener{

	public final static String ACTION_DELETE_STOCKPILE = "ACTION_DELETE_STOCKPILE";
	public final static String ACTION_EDIT_STOCKPILE = "ACTION_EDIT_STOCKPILE";
	public final static String ACTION_CLONE_STOCKPILE = "ACTION_CLONE_STOCKPILE";
	public final static String ACTION_SHOPPING_LIST_STOCKPILE = "ACTION_SHOPPING_LIST_STOCKPILE";
	public final static String ACTION_ADD_ITEM = "ACTION_ADD_ITEM";
	
	private final JLabel jGroup;
	private final JLabel jColor;
	private final JDropDownButton jStockpile;
	private final JLabel jLocation;
	private final JLabel jOwner;
	private final JLabel jPercent;
	private Program program;

	public StockpileSeparatorTableCell(Program program, JTable jTable, SeparatorList<StockpileItem> separatorList, ActionListener actionListener) {
		super(jTable, separatorList);
		this.program = program;
		
		jTable.addHierarchyListener(this);
		
		
		jColor = new JLabel();
		jColor.setOpaque(true);
		jColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		jStockpile = new JDropDownButton(TabsStockpile.get().stockpile());
		jStockpile.setOpaque(false);
		
		JMenuItem jMenuItem;
		
		JMenuItem jAdd = new JMenuItem(TabsStockpile.get().addItem());
		jAdd.setActionCommand(ACTION_ADD_ITEM);
		jAdd.addActionListener(actionListener);
		jStockpile.add(jAdd);
		
		jStockpile.addSeparator();
		
		jMenuItem = new JMenuItem(TabsStockpile.get().editStockpile());
		jMenuItem.setActionCommand(ACTION_EDIT_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);
		
		jMenuItem = new JMenuItem(TabsStockpile.get().cloneStockpile());
		jMenuItem.setActionCommand(ACTION_CLONE_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);
		
		jMenuItem = new JMenuItem(TabsStockpile.get().deleteStockpile());
		jMenuItem.setActionCommand(ACTION_DELETE_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);
		
		jStockpile.addSeparator();
		
		jMenuItem = new JMenuItem(TabsStockpile.get().getShoppingList());
		jMenuItem.setActionCommand(ACTION_SHOPPING_LIST_STOCKPILE);
		jMenuItem.addActionListener(actionListener);
		jStockpile.add(jMenuItem);
		
		jGroup = new JLabel();
		jGroup.setBorder(null);
		jGroup.setOpaque(false);
		jGroup.setFont(new Font(jGroup.getFont().getName(), Font.BOLD, jGroup.getFont().getSize()+1));
		
		JLabel jLocationLabel = new JLabel(TabsStockpile.get().stockpileLocation());
		jLocationLabel.setFont( new Font (jLocationLabel.getFont().getName(), Font.BOLD, jLocationLabel.getFont().getSize()) );
		jLocationLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		jLocation = new JLabel();
		jLocation.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel jPercentLabel = new JLabel(TabsStockpile.get().stockpilePercent());
		jPercentLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		jPercentLabel.setFont( new Font (jPercentLabel.getFont().getName(), Font.BOLD, jPercentLabel.getFont().getSize()) );
		
		jPercent = new JLabel();
		jPercent.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel jOwnerLabel = new JLabel(TabsStockpile.get().stockpileOwner());
		jOwnerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		jOwnerLabel.setFont( new Font (jOwnerLabel.getFont().getName(), Font.BOLD, jOwnerLabel.getFont().getSize()) );
		
		jOwner = new JLabel();
		jOwner.setVerticalAlignment(SwingConstants.BOTTOM);
		
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(2)
					.addComponent(jColor, Program.BUTTONS_HEIGHT-6, Program.BUTTONS_HEIGHT-6, Program.BUTTONS_HEIGHT-6)
					.addGap(10)
					.addComponent(jGroup)
					.addGap(10)
					.addComponent(jStockpile, Program.BUTTONS_WIDTH, Program.BUTTONS_WIDTH, Program.BUTTONS_WIDTH)
				)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jExpand)
					.addGap(7)
					.addComponent(jLocationLabel)
					.addGap(5)
					.addComponent(jLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jOwnerLabel)
					.addGap(5)
					.addComponent(jOwner, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jPercentLabel)
					.addGap(5)
					.addComponent(jPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGap(2)
				.addGroup(layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
						.addGap(3)
						.addComponent(jColor, Program.BUTTONS_HEIGHT-6, Program.BUTTONS_HEIGHT-6, Program.BUTTONS_HEIGHT-6)
					)
					.addComponent(jGroup, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addComponent(jStockpile, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
				)
				.addGap(1)
				.addGroup(layout.createParallelGroup()
					.addComponent(jExpand, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT, Program.BUTTONS_HEIGHT)
					.addGroup(layout.createSequentialGroup()
						.addGap(4)
						.addGroup(layout.createParallelGroup()
							.addComponent(jLocationLabel)
							.addComponent(jLocation)
							.addComponent(jOwnerLabel)
							.addComponent(jOwner)
							.addComponent(jPercentLabel)
							.addComponent(jPercent)
						)
					)
				)
				.addGap(4)
		);
	}
	
	@Override
	protected void configure(SeparatorList.Separator<?> separator) {
		StockpileItem stockpileItem = (StockpileItem) separator.first();
		if(stockpileItem == null) return; // handle 'late' rendering calls after this separator is invalid
		jGroup.setText(stockpileItem.getStockpile().getName());
		if (stockpileItem.getStockpile().isOK()){
			jColor.setBackground(new Color(200,255,200));
		} else if (stockpileItem.getStockpile().isHalf() && program.getSettings().isStockpileHalfColors()){
			jColor.setBackground(new Color(255,255,200));
		} else {
			jColor.setBackground(new Color(255,200,200));
		}
		String location = stockpileItem.getStockpile().getLocation();
		if (location != null){
			jLocation.setText(location);
		} else {
			jLocation.setText(TabsStockpile.get().all());
		}
		String owner = stockpileItem.getStockpile().getOwner();
		if (owner != null && !owner.isEmpty()){
			jOwner.setText(owner);
		} else {
			jOwner.setText(TabsStockpile.get().all());
		}
		String percent = stockpileItem.getStockpile().getPercentFull();
		if (percent != null && ! percent.isEmpty()){
			jPercent.setText(percent);
		}
	}
	
	protected JViewport getParentViewport(){
		Container container = jTable.getParent();
		if (container instanceof JViewport){
			return (JViewport) container;
		} else {
			return null;
		}
	}

	@Override
	public void hierarchyChanged(HierarchyEvent e) {
		if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) == HierarchyEvent.PARENT_CHANGED){
			JViewport jViewport = getParentViewport();
			if (jViewport != null){
				Container container = getParentViewport().getParent();
				if (container instanceof JScrollPane){
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
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (!e.getValueIsAdjusting()){
			int position = getParentViewport().getViewPosition().x;
			int width = getParentViewport().getSize().width;
			int offset = (width + position) - 134;
			jGroup.setMaximumSize(new Dimension(offset, jGroup.getMaximumSize().height) );
			if (jTable.isEditing() && (jTable.getCellEditor().getCellEditorValue() instanceof SeparatorList.Separator<?>)){
				int selectedRow = jTable.getSelectedRow();
				jTable.getCellEditor().cancelCellEditing();
				jTable.editCellAt(selectedRow, 0);
			}
			jTable.repaint();
		}
	}
}
