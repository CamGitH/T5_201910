package model.data_structures;

public class ArbolBin<T extends Comparable <T>> {
	private NodoBin<T> primero;
	private int tamano;

	public NodoBin<T> darPrimero(){
		return primero;
	}



	public ArbolBin(){
		primero = null;
		tamano =0;
	}

	/*
	 * lo pene de primero y lo intercambia con el mas alto
	 */
	private void swim(T k)
	{
	while (k > 1 && less(k/2, k))
	{
	exch(k/2, k);
	k = k/2;
	}
	}
	public void Sink(T nuevo){
		NodoBin<T> nodo = new NodoBin<T>(nuevo);
		if(tamano==0){
			primero= nodo;
		}
		else {
			primero=nodo;
			nodo= primero;
			if(nodo.darHijoIzq().darElemento().compareTo(nodo.darHijoIzq().darElemento())==-1){
				if(nodo.darElemento().compareTo(nodo.darHijoDer().darElemento())==-1){
					NodoBin<T> n = nodo.darHijoDer();
					
				}
			}
			else{
				if(nodo.darElemento().compareTo(nodo.darHijoDer().darElemento())==-1){

				}

			}
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