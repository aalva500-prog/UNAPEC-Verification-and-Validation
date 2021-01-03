package List;

import java.util.LinkedList;

import Model.Clase;

public class ClaseList {
	
	
	public static LinkedList<Clase> getClasesDeFisica(){
		LinkedList<Clase> list = new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0308", "43013", Clase.DaysListFisica1(), "<html>DE LA PAZ MELO<br>EDUARDO<br>YSMAEL</html> ", false);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0305","2",Clase.DaysListFisica2(),"<html>FUMERO<br>ALVAREZ<br>RAFAEL</html>",false);
		Clase c2 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0310","234",Clase.DaysListFisica3(),"<html>ALBERTO<br>ENRIQUEZ<br>CARLOS</html>",false);
		list.add(c);
		list.add(c1);
		list.add(c2);
		return list;
	}
	
	
	public static LinkedList<Clase> getClasesDeFisica1(){
		LinkedList<Clase> list = new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0308", "43013", Clase.DaysListFisica1(), "<html>DE LA PAZ MELO<br>EDUARDO<br>YSMAEL</html> ", true);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0305","2",Clase.DaysListFisica2(),"<html>FUMERO<br>ALVAREZ<br>RAFAEL</html>",false);
		Clase c2 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0310","234",Clase.DaysListFisica3(),"<html>ALBERTO<br>ENRIQUEZ<br>CARLOS</html>",false);
		list.add(c);
		list.add(c1);
		list.add(c2);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeFisica3(){
		LinkedList<Clase> list = new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0308", "43013", Clase.DaysListFisica1(), "<html>DE LA PAZ MELO<br>EDUARDO<br>YSMAEL</html> ", false);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0305","2",Clase.DaysListFisica2(),"<html>FUMERO<br>ALVAREZ<br>RAFAEL</html>",false);
		Clase c2 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0310","234",Clase.DaysListFisica3(),"<html>ALBERTO<br>ENRIQUEZ<br>CARLOS</html>",true);
		list.add(c);
		list.add(c1);
		list.add(c2);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeMatematica(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0310", "12013", Clase.DaysListMatematica1(), "<html>CORDERO<br>FREDDY</html> ", false);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0205","2023",Clase.DaysListMatematica2(),"<html>CASTRO<br>LÓPEZ<br>IVET</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeMatematica1(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0310", "12013", Clase.DaysListMatematica1(), "<html>CORDERO<br>FREDDY</html> ", true);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0205","2023",Clase.DaysListMatematica2(),"<html>CASTRO<br>LÓPEZ<br>IVET</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}

	public static LinkedList<Clase> getClasesDeProgramacion(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0309", "1201", Clase.DaysListProgramacion(), "<html>BELTRÉ<br>HAYSER</html> ", false);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0202","20",Clase.DaysListProgramacion1(),"<html>CONCEPCION<br>RAMIREZ<br>MILAGROS</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeProgramacion1(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0309", "1201", Clase.DaysListProgramacion(), "<html>BELTRÉ<br>HAYSER</html> ", true);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0202","20",Clase.DaysListProgramacion1(),"<html>CONCEPCION<br>RAMIREZ<br>MILAGROS</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeLiderazgo(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0510", "2013", Clase.DaysListLiderazgo1(), "<html>SUAREZ<br>NORBERTO</html> ", false);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0505","202",Clase.DaysListLiderazgo2(),"<html>FUENTES<br>VEGA<br>ONORIA</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}
	
	public static LinkedList<Clase> getClasesDeLiderazgo1(){
		LinkedList<Clase> list= new LinkedList<Clase>();
		Clase c = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>", "0510", "2013", Clase.DaysListLiderazgo1(), "<html>SUAREZ<br>NORBERTO</html> ", true);
		Clase c1 = new Clase("<html>Campus I -<br>Nicolás Pichardo</html>","0505","202",Clase.DaysListLiderazgo2(),"<html>FUENTES<br>VEGA<br>ONORIA</html>",false);
		list.add(c);
		list.add(c1);
		return list;
	}
}
