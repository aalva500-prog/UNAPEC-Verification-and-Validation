package Model;


public class Dia {
	private String descripción;
	private int horaInicio;
	private int horaFinal;	
	
	public Dia(String descripción, int horaInicio, int horaFinal) {
		super();
		this.descripción = descripción;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
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
