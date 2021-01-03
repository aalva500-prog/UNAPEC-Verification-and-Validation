package Utils;

import Model.Usuario;

public class CurrentUser {
	// Clase responsable de conocer el usuario que est� autenticado en la aplicaci�n
	private Usuario sessionUser = null;
    static CurrentUser currentU;
	
    private CurrentUser() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public static CurrentUser getCurrentUser()
    {
    	if(currentU == null)
    		currentU = new CurrentUser();
    	return currentU;
    }

	public Usuario getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(Usuario sessionUser) {
		this.sessionUser = sessionUser;
	}
}
