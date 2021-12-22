package ToxPredictor.Application.GUI.Table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import ToxPredictor.Application.GUI.Table.Renderer.CellRendererHCD;
import ToxPredictor.Application.GUI.Table.Renderer.CellRendererHCD_ScoreRecords;
import gov.epa.api.RecordLink;
import gov.epa.api.ScoreRecord;



public class MyTableModelLinks extends AbstractTableModel {

	protected int m_result = 0;

	protected int columnsCount = 1;
	
	static String [] fieldNames=RecordLink.fieldNames;
	
	JTable table;

	//TODO- maybe there's a way to use AtomContainerSet - messes up the Collections.sort- need to cast it somehow
	Vector<RecordLink> records;
	
	int sortCol;
	boolean isSortAsc=true;

	
	public void addLink(RecordLink rl) {
		// TODO Auto-generated method stub
		records.add(rl);		
	
		fireTableDataChanged();
		table.scrollRectToVisible(table.getCellRect(getRowCount() - 1, 0, true));
		table.repaint();

	}

	public MyTableModelLinks() {
		records=new Vector<RecordLink>();
		columnNames=getColumnNames();		
	}
			
	
	/** 
	 * Convert vector to ACS for use by other classes
	 * @return
	 */
	public  Vector<RecordLink> getRecords() {
		return records;
	}
	

	private String[] columnNames;

	public int getColumnCount() {
//		System.out.println(columnNames.length);
		return columnNames.length;
	}

	public int getRowCount() {
		return records.size();
	}
	
	
	public void setupTable(JTable table) {
		this.table=table;
		
		JTableHeader header = table.getTableHeader();

		header.setUpdateTableInRealTime(true);
		
		header.addMouseListener(this.new ColumnListener(table));

		table.setModel(this);
		
//		MultiLineTableHeaderRenderer renderer = new MultiLineTableHeaderRenderer();
//        Enumeration enumK = table.getColumnModel().getColumns();
//        while (enumK.hasMoreElements())
//        {
//            ((TableColumn) enumK.nextElement()).setHeaderRenderer(renderer);
//        }
//		
//		table.getColumnModel().getColumn(0).setPreferredWidth(15);
//		
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
//		System.out.println(table.getColumnModel().getColumnCount());
		
//		CellRendererHCD_ScoreRecords c=new CellRendererHCD_ScoreRecords();
//		c.setHorizontalAlignment(JLabel.CENTER);
//		table.getColumn("score").setCellRenderer(c);
		
//		table.setRowSelectionAllowed(false);
		
//		table.addMouseListener(new mouseAdapter());
//		table.addKeyListener(ka);
	}

	
	public static String [] getColumnNames () {
		return fieldNames;
	}

	
	public void updateRow(RecordLink recordLink,int row) {
		records.set(row, recordLink);
		fireTableDataChanged();
	}

	
	
	public String getColumnName(int col) {
//		System.out.println(col+"\t"+columnNames[col]);
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		RecordLink recordLink=records.get(row);
		return getValue(recordLink,col);
	}
	
	
	Object getValue(RecordLink recordLink,int col) {
		return recordLink.toStringArray().get(col);
	}

	
	

	
	public void sortByCol() {						
		Collections.sort(records,new CustomComparator(sortCol));
		
//		System.out.println(sortCol);
		
		if (!isSortAsc) Collections.reverse(records);
		
		fireTableDataChanged();
	}
	
	public void  removeRow(int row) {	
		records.remove(row);
		fireTableDataChanged();
	}
	
	class CustomComparator implements Comparator<RecordLink>{
	    int col;
		
		CustomComparator(int sortCol) {
			this.col=sortCol;
		}
		
		public int compare(RecordLink ac1, RecordLink ac2) {	        
	    	String val1=(String)getValue(ac1,col);
	    	String val2=(String)getValue(ac2,col);
	    	
	    	if (columnNames[col].equals("CAS")) {//CAS
	    		return MyTableModel.compareCAS_String(val1, val2);
	    	} else {
	    		return MyTableModel.compareString(val1, val2);
	    	}
		}
	}

	
	/*
	 * JTable uses this method to determine the default renderer/
	 * editor for each cell.  If we didn't implement this method,
	 * then the last column would contain text ("true"/"false"),
	 * rather than a check box.
	 */
	public Class getColumnClass(int c) {
		try {
			return String.class;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * Don't need to implement this method unless your table's
	 * editable.
	 */
	public boolean isCellEditable(int row, int col) {
		//Note that the data/cell address is constant,
		//no matter where the cell appears onscreen.
		//			if (col < 2) {
		//				return false;
		//			} else {
		//				return true;
		//			}

		return false;
	}


	class ColumnListener extends MouseAdapter {
		protected JTable table;


		public ColumnListener(JTable t) {
			table = t;
		}

		public void mouseClicked(MouseEvent e) {

			TableColumnModel colModel = table.getColumnModel();
			int columnModelIndex = colModel.getColumnIndexAtX(e.getX());

			int modelIndex = colModel.getColumn(columnModelIndex)
					.getModelIndex();

			if (modelIndex < 0)
				return;

			sortCol=modelIndex;
			isSortAsc = !isSortAsc;
			//System.out.println(isSortAsc);
			
			if (columnModelIndex!=modelIndex) {
				System.out.println("mismatch!");
			}
			sortByCol();

		}
	}

	

	/**
	 * Remove all rows from table
	 */
	public void clear() {
		records.clear();
		fireTableDataChanged();
	}

	public RecordLink getLink(int row) {
		return records.get(row);
	}

	

}