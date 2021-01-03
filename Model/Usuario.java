package Model;

public class Usuario {
	private int idUsuario;
	private String matricula;
	private String clave;	
	private String nombre;	
	
	public Usuario(int idUsuario, String matricula, String clave, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.matricula = matricula;
		this.clave = clave;
		this.nombre = nombre;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIsUsuario() {
		return idUsuario;
	}

	public void setIsUsuario(int isUsuario) {
		this.idUsuario = isUsuario;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
