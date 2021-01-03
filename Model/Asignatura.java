package Model;

public class Asignatura {
	private String descripcionAsig;
	private String codigo;
	private int cuatrimestre;
	private int creditos;
	private String Estado;
	
	
	
public Asignatura(String descripcionAsig, String codigo,
			int cuatrimestre, int creditos, String preRequisito) {
		super();
		this.descripcionAsig = descripcionAsig;
		this.codigo = codigo;
		this.cuatrimestre = cuatrimestre;
		this.creditos = creditos;
		this.Estado = preRequisito;
}


	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDescripcionAsig() {
		return descripcionAsig;
	}


	public void setDescripcionAsig(String descripcionAsig) {
		this.descripcionAsig = descripcionAsig;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getCuatrimestre() {
		return cuatrimestre;
	}


	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}


	public int getCreditos() {
		return creditos;
	}


	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String preRequisito) {
		this.Estado = preRequisito;
	}
}
