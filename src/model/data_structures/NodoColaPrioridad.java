package model.data_structures;
import java.io.Serializable;

/**
 * Nodo de la cola de prioridad de tipo Queue
 * @author Tomas
 *Basado en el nodo de: Universidad de los Andes. Cupi2 Estructuras de datos. Cola Prioridad, clase nodo.
 * @param <T>
 */
public class NodoColaPrioridad<T extends Comparable<? super T>> implements Serializable
{

	private static final long serialVersionUID = 1L;

	
	private T elemento;


	private NodoColaPrioridad<T> sigNodo;

	

	public NodoColaPrioridad(T pElemento )
	{
		elemento = pElemento;
		sigNodo = null;
	}

	
	public T darElemento( )
	{
		return elemento;
	}

	
	/**
	 * Desconecta el nodo de la cola suponiendo que es el primero. <br>
	 * <b>pre: </b> El nodo actual es el primer nodo de la cola. <br>
	 * <b>post: </b> Se retornó el nodo con el cual comienza la cola ahora, sigNodo=null.<br>
	 * @return Nodo con el cual comienza la cola ahora.<br>
	 */
	public NodoColaPrioridad<T> desconectarPrimero( )
	{
		NodoColaPrioridad<T> p = sigNodo;
		sigNodo = null;
		return p;
	}

	/**
	 * Inserta el nodo especificado después del nodo actual. <br>
	 * <b>post: </b> Se insertó el nodo después del nodo actual lo que implica que sigNodo=nodo.<br>
	 * @param nodo El nodo a ser insertado<br>
	 * @return Nodo que se insertó después del nodo actual<br>
	 */
	public NodoColaPrioridad<T> insertarDespues( NodoColaPrioridad<T> nodo )
	{
		sigNodo = nodo;
		return nodo;
	}


	public NodoColaPrioridad<T> darSiguiente( )
	{
		return sigNodo;
	}

	
	@Override
	public String toString( )
	{
		return "(" + elemento.toString( ) + ")";
	}
}