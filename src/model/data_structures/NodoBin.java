package model.data_structures;

import java.io.Serializable;

public class NodoBin <T extends Comparable<T>> {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la serialización
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Elemento del nodo
	 */
	private T elemento;

	/**
	 * Elemento que le dara la prioridad al nodo de la cola
	 */
	/**
	 * Siguiente elemento encadenado izquierda
	 */
	private NodoBin<T> hijoIzq;
	/**
	 * Siguiente elemento encadenado derecha
	 */
	private NodoBin<T> hijoDer;

	private NodoBin<T> padre;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor por parámetros del nodo. <br>
	 * <b>post: </b> Se construyó el nodo con el elemento especificado, sigNodo=null y elemento = pElemento.<br>
	 * @param pPrioridad Elemento que le da la prioridad al nodo de la cola. Diferente de null.<br>
	 * @param pElemento Elemento que va a ser almacenado en el nodo. Diferente de null<br>
	 */
	public NodoBin(T pElemento) {
	
		elemento = pElemento;
		hijoIzq = null;
		hijoDer = null;
		padre = null;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el elemento del nodo. <br>
	 * <b>post: </b> Se retornó el elemento contenido en el nodo.<br>
	 * @return El elemento contenido en el nodo. Diferente de null<br>
	 */
	public T darElemento( )
	{
		return elemento;
	}

	 /*
	  * da el hijo de la derecha y lo borra
	  */
	public NodoBin<T> darDer( )
	{
		NodoBin<T> p = hijoDer;
		hijoDer=null;
		return p;
	}
	 /*
	  * da el hijo de la izquierda y lo borra
	  */
	public NodoBin<T> darIzq( )
	{
		NodoBin<T> p = hijoIzq;
		hijoIzq=null;
		return p;
	}

	/**
	 * Retorna el siguiente nodo. por la derecha <br>
	 * <b>post: </b> Se retornó el siguiente nodo.<br>
	 * @return El nodo siguiente<br>
	 */
	public NodoBin<T> darHijoDer( )
	{
		return hijoDer;
	}
	
	/**
	 * Retorna el siguiente nodo. por la izquierda <br>
	 * <b>post: </b> Se retornó el siguiente nodo.<br>
	 * @return El nodo siguiente<br>
	 */
	public NodoBin<T> darHijoIzq( )
	{
		return hijoIzq;
	}
	
	public NodoBin<T> darPadre( )
	{
		return padre;
	}

	/**
	 * Convierte el nodo a un String. <br>
	 * <b>post: </b> Se retornó la representación en String del nodo. Dicha representación corresponde a la representación en String del elemento que contiene.
	 * @return La representación en String del nodo
	 */
	@Override
	public String toString( )
	{
		return "(" + elemento.toString( ) + ")";
	}
	
	
}

