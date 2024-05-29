package eje9;
import eje1.GeneralTree;
import java.util.LinkedList;
import java.util.List;
public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		boolean ok= false;
		if(!arbol.isEmpty() && !arbol.isLeaf()) {
			ok= verificar(arbol);
		}
		return ok;
	}
	private static boolean verificar(GeneralTree<Integer> arbol) {
		boolean ok= true;
		if(arbol.hasChildren()) {
			int indice=0;
			Integer intActual= arbol.getData(), camino=Integer.MAX_VALUE; 
			while(ok && indice < arbol.getChildren().size()) {
				ok = verificar(arbol.getChildren().get(indice));
				camino = Math.min(camino, arbol.getChildren().get(indice).getData());
				indice++;
			}
			if(ok && !intActual.equals(camino)) ok= false; 
		}
		return ok;
	}
	
	
	public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
        
        /*No iba a hacer otro arbol, probe seteando los datos y me daba true igual,
        la idea es descomentar esto y las otras lineas comentadas para probar el segundo
        arbol de la practica mostrado como ejemplo. Ademas de comentar los nodos con valor 12*/
        //System.out.println("Es de seleccion el segundo arbol: " + esDeSeleccion(a)); 
    
}
}