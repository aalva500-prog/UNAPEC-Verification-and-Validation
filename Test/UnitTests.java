package Test;

import Model.Usuario;
import Utils.CurrentUser;

public class UnitTests {
	
	public static void main (String args[]) throws Exception{
		Usuario usuario = new Usuario(0,"20141644",null,"ALVAREZ AGUIRRE AARON");
		CurrentUser.getCurrentUser().setSessionUser(usuario);
		System.out.println("Matrícula:  "+CurrentUser.getCurrentUser().getSessionUser().getMatricula() +
				           "   Nombre:  "+CurrentUser.getCurrentUser().getSessionUser().getNombre());			
			
		System.in.read();
	}

}

