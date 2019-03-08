package colas;

import java.io.Serializable;
/**
 * @param <T>
 * @param <E>
 */
public interface IColaPrioridad<T extends Comparable<? super T>, E> extends Serializable  {
	
	int darLongitud( );
	
	E tomarElemento( );
	
	void insertar( T prioridad, E elem );
	
	NodoColaPrioridad<T, E> darPrimero;
	
	NodoColaPrioridad<T, E> darUltimo;
	
	 boolean estaVacia( );
	 
	 T delMax ();
	
	 T max();
}
