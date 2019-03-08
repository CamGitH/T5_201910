package colas;

import java.util.Iterator;

/**
 * @param <T>
 */
public class LinkedList<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tamano=0;

	public Nodo<T> darPrimero(){
		return primero;
	}

	public Nodo<T> darUltimo(){
		return ultimo;
	}

	public LinkedList()
	{
		primero = null;
		ultimo = null;
		tamano = 0;
	}

	public void agregarIni(T nuevo){
		Nodo<T> nodo = new Nodo<T>(nuevo);
		if(tamano==0){
			primero= nodo;
			ultimo= nodo;
			tamano ++;
		}
		else{
			nodo.cambiarSiguiente(primero);
			primero=nodo;
			primero.darSiguiente().cambiarAnterior(primero);
			tamano ++;
		}
	}

	public void agregarFinal(T nuevo){
		Nodo<T> nodo = new Nodo<T>(nuevo);
		if(tamano==0){

			primero= nodo;
			ultimo= nodo;
			tamano ++;
		}
		else{
			ultimo.cambiarSiguiente(nodo);
			nodo.cambiarAnterior(ultimo);
			ultimo=nodo;

			tamano ++;
		}
	}

	public Integer getSize() {
		return tamano;
	}

	public void eliminarUltimo() throws Exception{
		if (tamano==0){
			throw new Exception("La lista no existe");
		}
		else if(tamano==1){
			primero=null;
			ultimo=null;
		}
		else{
			ultimo.darAnterior().cambiarSiguiente(null);
			ultimo= ultimo.darAnterior();
			tamano --;
		}
	}

	public void eliminarPrimero() throws Exception{
		if (tamano==0){
			throw new Exception("La lista no existe");
		}
		else if(tamano==1){
			primero=null;
			ultimo=null;
		}
		else{
			((Nodo<T>) primero).darSiguiente().cambiarAnterior(null);
			primero=primero.darSiguiente();
			tamano --;
		}
	}
}
