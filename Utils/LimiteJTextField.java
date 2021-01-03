 package Utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteJTextField  extends PlainDocument{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limite;
	
	public LimiteJTextField(int i){
		super();
		this.limite=i;
	}
	
	
	
	public void insertString(int compensacion, String src, AttributeSet attr) throws BadLocationException{
		if(src==null) return;
		if(getLength()+src.length() <= limite){
			super.insertString(compensacion, src, attr);
		}
	}
	
	
	

}
