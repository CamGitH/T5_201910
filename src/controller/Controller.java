package controller;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


import model.data_structures.LinkedList;
import model.data_structures.MaxColaPrioridad;
import model.data_structures.MaxHeapCP;

import model.data_structures.NodoLinkedList;
import model.sort.Sort;
import model.violations.LocationVO;
import model.violations.VOMovingViolations;
import view.View;

public class Controller {

	private View view;

	private LinkedList<VOMovingViolations> listaEncadenda;

	private LinkedList<VOMovingViolations> listaMuestra;

	private MaxColaPrioridad<LocationVO> colaQuaue;

	private MaxHeapCP<LocationVO> colaHeap;

	private ArrayList<LocationVO> datosLocationVO;


	// TODO Definir las estructuras de datos para cargar las infracciones del periodo definido

	// Muestra obtenida de los datos cargados 
	Comparable<VOMovingViolations> [ ] muestra;

	// Copia de la muestra de datos a ordenar 
	Comparable<VOMovingViolations> [ ] muestraCopia;

	Comparable<VOMovingViolations> [ ] comparables;

	public Controller() {
		view = new View();

		//TODO inicializar las estructuras de datos para la carga de informacion de archivos
		listaEncadenda = new LinkedList<VOMovingViolations>();
	}

	@SuppressWarnings("unchecked")
	public Comparable<VOMovingViolations> [ ] generarMuestra( int n )
	{
		if(n > 240000){
			try {
				throw new Exception("El numero es muy grande. Max 240000");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		muestra = new Comparable[ n ];
		NodoLinkedList<VOMovingViolations> objeto = listaEncadenda.darPrimero();;
		for(int i = 0; i<n;i++){
			Random random = new Random();
			int indice = random.nextInt(1000);
			while(indice > 0){

				if(objeto.darSiguiente()==null){
					objeto=listaEncadenda.darPrimero();
				}
				objeto = objeto.darSiguiente();
				indice--;
			}
			muestra[i] = objeto.darElemento();
			listaMuestra.agregarIni(objeto.darElemento());


		}
		return muestra;
	}
	@SuppressWarnings("unchecked")
	public Comparable<VOMovingViolations> [ ] obtenerCopia( Comparable<VOMovingViolations> [ ] muestra)
	{
		Comparable<VOMovingViolations> [ ] copia = new Comparable[ muestra.length ]; 
		for ( int i = 0; i < muestra.length; i++)
		{    copia[i] = muestra[i];    }
		return copia;
	}

	/**
	 * Leer los datos de las infracciones de los archivos. Cada infraccion debe ser Comparable para ser usada en los ordenamientos.
	 * Todas infracciones (MovingViolation) deben almacenarse en una Estructura de Datos (en el mismo orden como estan los archivos)
	 * A partir de estos datos se obtendran muestras para evaluar los algoritmos de ordenamiento
	 * @return numero de infracciones leidas 
	 */
	public int loadMovingViolations() {

		List<String[]> list = new ArrayList<String[]>();

		CSVReader reader =null;

		try{

			reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_January_2018.csv")).withSkipLines(1).build();

			list = reader.readAll();
			readFiles(list);
			list.clear();

			reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_February_2018.csv")).withSkipLines(1).build();

			list = reader.readAll();
			readFiles(list);
			list.clear();

			reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_March_2018.csv")).withSkipLines(1).build();

			list = reader.readAll();
			readFiles(list);
			list.clear();

			reader=new CSVReaderBuilder(new FileReader("./data/Moving_Violations_Issued_in_April_2018.csv")).withSkipLines(1).build();

			list = reader.readAll();
			readFiles(list);
			list.clear();


		}catch( Exception e){

			e.printStackTrace();

		}


		return listaEncadenda.getSize();
	}

	public void cargarDatosLocationVO(){

		Sort.ordenarShellSort(muestra, new VOMovingViolations.AddressID());

		NodoLinkedList<VOMovingViolations> nodo = listaMuestra.darPrimero();

		String address = "";
		int numberOfRegisters = 0;
		String location = "";

		colaHeap = new MaxHeapCP<LocationVO>();
		colaQuaue = new MaxColaPrioridad<LocationVO>();

		while(nodo.darElemento()!=null){

			address = nodo.darElemento().getAddressID();
			numberOfRegisters = 1;
			location = nodo.darElemento().getLocation();

			while(nodo.darSiguiente()!=null && nodo.darSiguiente().darElemento().getAddressID().equals(address)){

				numberOfRegisters++;
				nodo=nodo.darSiguiente();
			}

			LocationVO locationData = new LocationVO(Integer.parseInt(address),numberOfRegisters, location);

			datosLocationVO.add(locationData);

			nodo = nodo.darSiguiente();


		}
	}

	public void agregarMaxHeap(){

		cargarDatosLocationVO();

		for(int i = 0; i<datosLocationVO.size();i++){

			colaHeap.agregar(datosLocationVO.get(i));
		}

	}

	public void agregarMaxColaPrioridad(){

		cargarDatosLocationVO();

		for(int i = 0; i<datosLocationVO.size();i++){

			colaQuaue.agregar(datosLocationVO.get(i));
		}

	}

	public void readFiles(List<String[]> list){


		for(int i = 0;i<list.size();i++){


			listaEncadenda.agregarIni(new VOMovingViolations(
					list.get(i)[0], 
					list.get(i)[1], 
					list.get(i)[2], 
					list.get(i)[3], 
					list.get(i)[4], 
					list.get(i)[5], 
					list.get(i)[6], 
					list.get(i)[7],
					list.get(i)[8], 
					list.get(i)[9],
					list.get(i)[10], 
					list.get(i)[11], 
					list.get(i)[12], 
					list.get(i)[13], 
					list.get(i)[14], 
					list.get(i)[15],
					list.get(i)[16]));
		}
	}

	@SuppressWarnings("unchecked")
	public void generarComparables(){
		comparables = new Comparable[listaEncadenda.getSize()];
		NodoLinkedList<VOMovingViolations> objeto = listaEncadenda.darPrimero();;

		int i=0;
		while(objeto.darElemento()!=null){

			comparables[i] = objeto.darElemento();
			i++;
			objeto=objeto.darSiguiente();
		}
	}
	public void  crearMaxColaP  (LocalDateTime  fInicial,  LocalDateTime fFinal){
		
	}
	public void  crearMaxHeapCP  (LocalDateTime  fInicial,  LocalDateTime fFinal){
		
	}


	public void run() {

		long startTime;
		long endTime;
		long duration;

		int nDatos = 0;
		int nMuestra = 0;

		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 1:

				nDatos = this.loadMovingViolations();
				view.printMensage("Numero infracciones cargadas:" + nDatos);
				break;

			case 2:
				view.printMensage("Dar tamaNo de la muestra: ");
				nMuestra = sc.nextInt();
				muestra = this.generarMuestra( nMuestra );
				view.printMensage("Muestra generada");
				break;


			case 3:
				if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
				{    
					view.printDatosMuestra( nMuestra, muestra);
				}
				else
				{
					view.printMensage("Muestra invalida");
				}
				break;

			case 4:

				startTime = System.currentTimeMillis();
				this.agregarMaxColaPrioridad();
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMensage("Tiempo de la operacion: " + duration + " milisegundos");
				break;

			case 5:

				startTime = System.currentTimeMillis();
				this.agregarMaxHeap();
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMensage("Tiempo de la operacion: " + duration + " milisegundos");
				break;

			case 6:
				String fecha1 = sc.nextLine();
				String fecha2 = sc.nextLine();
				startTime = System.currentTimeMillis();
				LocalDateTime tiempo = convertirFecha_Hora_LDT(fecha1);
				LocalDateTime tiempo2 = convertirFecha_Hora_LDT(fecha2);
				this.crearMaxColaP(tiempo, tiempo2);
				endTime = System.currentTimeMillis();
				long tiempoQueue = endTime - startTime;
				startTime = System.currentTimeMillis();
				this.crearMaxHeapCP(tiempo, tiempo2);
				endTime = System.currentTimeMillis();
				long tiempoHeap = endTime - startTime;
				view.printMensage("El tiempo de la MaxColaP es: " + tiempoQueue + " milisegundos");
				view.printMensage("El tiempo de la MaxColaP es: " + tiempoHeap + " milisegundos");
				
			case 7:	
				fin=true;
				sc.close();
				break;
			}
		}
	}
	private static LocalDateTime convertirFecha_Hora_LDT(String fechaHora)
	{
		return LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss"));
	}

}

