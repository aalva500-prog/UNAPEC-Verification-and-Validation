package Model;


public class Dia {
	private String descripci�n;
	private int horaInicio;
	private int horaFinal;	
	
	public Dia(String descripci�n, int horaInicio, int horaFinal) {
		super();
		this.descripci�n = descripci�n;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}
}
