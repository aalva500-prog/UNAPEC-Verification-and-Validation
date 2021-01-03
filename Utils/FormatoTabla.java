package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class FormatoTabla implements TableCellRenderer{
	public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
	Font normal = new Font( "Tahoma",Font.PLAIN,12 );
    Font negrilla = new Font( "Tahoma",Font.BOLD,12 );
    Font cursiva = new Font( "Tahoma",Font.ITALIC,12 );


	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
	        table, value, isSelected, hasFocus, row, column);
	    Color foreground = null, background = null;
	    renderer.setEnabled(table == null || table.isEnabled());	 
	    ((JLabel) renderer). setHorizontalAlignment(2);
	    table.setFont(negrilla); 
	    
	    if (isSelected) {
	      foreground = Color.BLACK;
	      background = new Color(0,153,255);
	    } else {
	      if (row % 2 == 0) {
	    	  foreground = Color.WHITE;
		        background = Color.DARK_GRAY;
	      } else {
	        foreground = Color.WHITE;
	        background = Color.DARK_GRAY;
	      }
	    	  /*--------*/
	       
	    }
	    renderer.setForeground(foreground);
	    renderer.setBackground(background);
	    return renderer;
	  }
	

}
