package model.data_structures;

public class ArbolBin<T> {
	private NodoBin<T> primero;
	private int tamano;
	
	public NodoBin<T> darPrimero(){
		return primero;
	}

	

	public ArbolBin(){
		primero = null;
		tamano =0;
	}

	public void Sink(T nuevo){
		NodoBin<T> nodo = new NodoBin<T>(nuevo);
		if(tamano==0){
			primero= nodo;
		}
		else if(nodo.darElemento().compareTo){
			nodo.cambiarSiguiente(primero);
			primero=nodo;
		}
	}

	public void Swim(T nuevo){
		NodoBin<T> nodo = new NodoBin<T>(nuevo);
		if(tamano==0){

			primero= nodo;
		}
		else{
			ultimo.cambiarSiguiente(nodo);
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
			((NodoBin<T>) primero).darSiguiente().cambiarAnterior(null);
			primero=primero.darSiguiente();
		
		}
	}
}