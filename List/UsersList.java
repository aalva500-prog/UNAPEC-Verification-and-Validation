package List;
import java.util.LinkedList;

import Model.Usuario;

public class UsersList {
	
	private static  LinkedList<Usuario> usuarios;
	

	public UsersList(LinkedList<Usuario> usuarios) {
		super();
		UsersList.usuarios = usuarios;		
	}	
	
	public UsersList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static LinkedList<Usuario> getUsuarios() {
		usuarios = ListUsers();
		return usuarios;
	}

	public void setUsuarios(LinkedList<Usuario> usuarios) {
		UsersList.usuarios = usuarios;
	}

	
	public static LinkedList<Usuario> ListUsers(){
		LinkedList<Usuario> users = new LinkedList<Usuario>();
		Usuario user = new Usuario(1,"20141644","Abc1234*","ALVAREZ AGUIRRE AARON");
		Usuario user1 = new Usuario(2,"20130170","Abc1234*","REYNOSO JUAREZ");
		Usuario user2 = new Usuario(3,"20131448","Abc1234*","RIVAS WLISES");
		Usuario user3 = new Usuario(4,"20131241","Abc1234*", "VALDES SAMANTHA");
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}
}
