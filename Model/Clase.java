package Model;

import java.util.LinkedList;

public class Clase {
	private String campus;
	private String aula;
	private String grupo;
	private LinkedList<Dia> dias; 
	private String nombreProfesor;
	private boolean seleccion;
	
	
	public Clase(String campus, String aula, String grupo,
			LinkedList<Dia> dias, String nombreProfesor, boolean seleccion) {
		super();
		this.campus = campus;
		this.aula = aula;
		this.grupo = grupo;
		this.dias = dias;
		this.nombreProfesor = nombreProfesor;
		this.seleccion = seleccion;
	}


	public Clase() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCampus() {
		return campus;
	}


	public void setCampus(String campus) {
		this.campus = campus;
	}


	public String getAula() {
		return aula;
	}


	public void setAula(String aula) {
		this.aula = aula;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public LinkedList<Dia> getDias() {
		return dias;
	}


	public void setDias(LinkedList<Dia> dias) {
		this.dias = dias;
	}


	public String getNombreProfesor() {
		return nombreProfesor;
	}


	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}


	public boolean isSeleccion() {
		return seleccion;
	}


	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}
	
public static LinkedList<Dia> DaysListFisica1(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	Dia lunes = new Dia("Lunes",0,0);
	Dia martes = new Dia("Martes",0,0);
	Dia miercoles = new Dia("Miércoles",0,0);
	Dia jueves = new Dia("Jueves",0,0);
	Dia viernes = new Dia("Viernes",17,20);
	Dia sabado = new Dia("Sábado",0,0);
	Dia domingo = new Dia("Domingo",8,10);
	dias.add(lunes);
	dias.add(martes);
	dias.add(miercoles);
	dias.add(jueves);
	dias.add(viernes);
	dias.add(sabado);
	dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListFisica3(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	Dia lunes = new Dia("Lunes",17,20);
	Dia martes = new Dia("Martes",0,0);
	Dia miercoles = new Dia("Miércoles",0,0);
	Dia jueves = new Dia("Jueves",18,20);
	Dia viernes = new Dia("Viernes",0,0);
	Dia sabado = new Dia("Sábado",0,0);
	Dia domingo = new Dia("Domingo",0,0);
	dias.add(lunes);
	dias.add(martes);
	dias.add(miercoles);
	dias.add(jueves);
	dias.add(viernes);
	dias.add(sabado);
	dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListFisica2(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
    Dia lunes = new Dia("Lunes",0,0);
	Dia martes = new Dia("Martes",15,18);
	Dia miercoles = new Dia("Miércoles",0,0);
	Dia jueves = new Dia("Jueves",0,0);
	Dia viernes = new Dia("Viernes",18,20);
	Dia sabado = new Dia("Sábado",0,0);
	Dia domingo = new Dia("Domingo",0,0);
	dias.add(lunes);
	dias.add(martes);
	dias.add(miercoles);
	dias.add(jueves);
	dias.add(viernes);
	dias.add(sabado);
	dias.add(domingo);
	return dias;
}	
	
public static LinkedList<Dia> DaysListMatematica1(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",0,0);
		Dia martes = new Dia("Martes",20,22);
		Dia miercoles = new Dia("Miércoles",19,22);
		Dia jueves = new Dia("Jueves",0,0);
		Dia viernes = new Dia("Viernes",0,0);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",0,0);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListMatematica2(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",0,0);
		Dia martes = new Dia("Martes",0,0);
		Dia miercoles = new Dia("Miércoles",0,0);
		Dia jueves = new Dia("Jueves",0,0);
		Dia viernes = new Dia("Viernes",19,22);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",8,10);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListProgramacion(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",0,0);
		Dia martes = new Dia("Martes",0,0);
		Dia miercoles = new Dia("Miércoles",0,0);
		Dia jueves = new Dia("Jueves",19,20);
		Dia viernes = new Dia("Viernes",18,20);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",0,0);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListProgramacion1(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",0,0);
		Dia martes = new Dia("Martes",0,0);
		Dia miercoles = new Dia("Miércoles",0,0);
		Dia jueves = new Dia("Jueves",0,0);
		Dia viernes = new Dia("Viernes",0,0);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",8,11);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListLiderazgo1(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",0,0);
		Dia martes = new Dia("Martes",18,20);
		Dia miercoles = new Dia("Miércoles",18,19);
		Dia jueves = new Dia("Jueves",0,0);
		Dia viernes = new Dia("Viernes",0,0);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",0,0);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

public static LinkedList<Dia> DaysListLiderazgo2(){
	LinkedList<Dia> dias = new LinkedList<Dia>();
	 Dia lunes = new Dia("Lunes",18,19);
		Dia martes = new Dia("Martes",0,0);
		Dia miercoles = new Dia("Miércoles",0,0);
		Dia jueves = new Dia("Jueves",16,18);
		Dia viernes = new Dia("Viernes",0,0);
		Dia sabado = new Dia("Sábado",0,0);
		Dia domingo = new Dia("Domingo",0,0);
		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);
	return dias;
}	

}
