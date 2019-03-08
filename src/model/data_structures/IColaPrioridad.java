package model.data_structures;

/**
 * @param <T>
 */
public interface IColaPrioridad<T> {
	
	int darNumElementos( );
	
	T tomarElemento( );
	
	void agregar( T elemento );
	
	 boolean estaVacia( );
	 
	 T delMax ();
	
	 T max();
}
