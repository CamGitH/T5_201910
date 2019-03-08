package controller;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ColaPrioridad;
import model.data_structures.NodoColaPrioridad;
import model.violations.VOMovingViolations;

import view.View;

public class Controller {

	private View view;

	private LinkedList<VOMovingViolations> listaEncadenda;

	// TODO Definir las estructuras de datos para cargar las infracciones del periodo definido

	// Muestra obtenida de los datos cargados 
	Comparable<VOMovingViolations> [ ] muestra;

	// Copia de la muestra de datos a ordenar 
	Comparable<VOMovingViolations> [ ] muestraCopia;

	public Controller() {
		view = new View();

		//TODO inicializar las estructuras de datos para la carga de informacion de archivos
		listaEncadenda = new ColaPrioridad<String, VOMovingViolations>();
	}
	
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
		Nodo<VOMovingViolations> objeto = listaEncadenda.darPrimero();;
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
			

		}
		return muestra;
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

	public void readFiles(List<String[]> list){


		for(int i = 0;i<list.size();i++){

			
			listaEncadenda.insertar(new VOMovingViolations(
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


	public void run() {

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
				fin=true;
				sc.close();
				break;
			}
		}
	}

}

