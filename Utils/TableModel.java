package Utils;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TableModel (){
		super();
	}
	
	public TableModel (Object [] arg0, int arg1){
		super(arg0, arg1);
	}
	
	
	public boolean isCellEditable (int fila, int column){
		if(column==11)
			return true;
		else
		return false;
	}

	
	
}
