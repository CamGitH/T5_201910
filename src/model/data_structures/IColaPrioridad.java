package model.data_structures;

/**
 * @param <T>
 * @param <E>
 */
public interface IColaPrioridad<T extends Comparable<? super T>, E> {
	
	int darNumElementos( );
	
	E tomarElemento( );
	
	void agregar( T elemento );
	
	 boolean estaVacia( );
	 
	 T delMax ();
	
	 T max();
}
