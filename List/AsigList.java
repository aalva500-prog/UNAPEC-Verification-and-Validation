package List;

import java.util.LinkedList;

import Model.Asignatura;

public class AsigList {
private static LinkedList<Asignatura> asignaturas;

public AsigList(LinkedList<Asignatura> asignaturas) {
	super();
	AsigList.asignaturas = asignaturas;
}

public AsigList() {
	super();
	// TODO Auto-generated constructor stub
}

public static LinkedList<Asignatura> getAsignaturas() {
	asignaturas=ListaAsig();
	return asignaturas;
}

public void setAsignaturas(LinkedList<Asignatura> asignaturas) {
	AsigList.asignaturas = asignaturas;
}

public static LinkedList<Asignatura> ListaAsig(){
	LinkedList<Asignatura> list = new LinkedList<Asignatura>();
	Asignatura asig= new Asignatura("<html>F�SICA I<br>Y LABORATORIO</html>", "ING701", 2, 5, "");
	Asignatura asig1= new Asignatura("<html>MATEM�TICA SUPERIOR<br> PARA INGENIER�A</html>", "MAT127", 2, 5, "");
	Asignatura asig2= new Asignatura("<html>PROGRAMACI�N ORIENTADA<br> A OBJETOS</html>", "INF111", 3, 3, "");
	Asignatura asig3= new Asignatura("<html>LIDERAZGO Y T�CNICAS <br>DE SUPERVISI�N </html>", "ADM120", 9, 3, "");
	list.add(asig);
	list.add(asig1);
	list.add(asig2);
	list.add(asig3);
	return list;
}

}
