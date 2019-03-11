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
	private void swim(T n)
	{
		NodoBin<T> k = new NodoBin<T>(n);
		while (k.darElemento().compareTo(k.darHijoDer().darElemento()) > 1) 	{
			exch(k/2, k);
			k = k/2;
		}
	}

	private void sink(T n)
	{
		NodoBin<T> k = new NodoBin<T>(n);
		while (k.darElemento().compareTo(k.darPadre().darElemento()) <= 1)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	//	public void Sink(T nuevo){
	//
	//		if(tamano==0){
	//			primero= nodo;
	//		}
	//		else {
	//			primero=nodo;
	//			nodo= primero;
	//			if(nodo.darHijoIzq().darElemento().compareTo(nodo.darHijoIzq().darElemento())==-1){
	//				if(nodo.darElemento().compareTo(nodo.darHijoDer().darElemento())==-1){
	//					NodoBin<T> n = nodo.darHijoDer();
	//					
	//				}
	//			}
	//			else{
	//				if(nodo.darElemento().compareTo(nodo.darHijoDer().darElemento())==-1){
	//
	//				}
	//
	//			}
	//		}
	//	}
	//
	//	public void Swim(T nuevo){
	//		NodoBin<T> nodo = new NodoBin<T>(nuevo);
	//		if(tamano==0){
	//
	//			primero= nodo;
	//		}
	//		else{
	//			ultimo.cambiarSiguiente(nodo);
	//		}
	//	}

	public Integer getSize() {
		return tamano;
	}

	public void eliminarUltimo() throws Exception{
		NodoBin n=primero;
		while(primero.darHijoDer()!=null){
			n = n.darHijoDer();
		}
	}

	public void eliminarPrimero() throws Exception{
		if (tamano==0){
			throw new Exception("La lista no existe");
		}
		else if(tamano==1){
			primero=null;
		
	
		}
	}
}