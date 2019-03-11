package view;

public class View {

	public View() {

	}

	public void printMenu() {
		System.out.println("---------ISIS------- Estructuras de datos----------");
		System.out.println("---------------------Taller 5----------------------");
		System.out.println("1. Cargar datos");
		System.out.println("2. Obtener una muestra de datos a ordenar");
		System.out.println("3. Mostrar la muestra de datos a ordenar");
		System.out.println("4. Cargar datos a la MaxColaPrioridad");
		System.out.println("5. CargarDatos a la MaxHeapCP");
		System.out.println("6.  Dar N vías que tienen la  mayor  cantidad  de  infracciones");
		System.out.println("10. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");

	}

	public void printDatosMuestra( int nMuestra, Comparable [ ] muestra)
	{
		for ( Comparable dato : muestra)
		{	System.out.println(  dato.toString() );    }

	}

	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}

}
