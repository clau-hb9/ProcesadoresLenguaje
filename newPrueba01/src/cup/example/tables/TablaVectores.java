package cup.example.tables;

import java.util.*;



/* Almacenamiento de las variables de tipo vector */
public class TablaVectores {

	HashMap t;
	
	public TablaVectores(){
		 t = new HashMap();
	 }

	public Vector insertar(String nombre, Integer dimension, Object valorInicial){
		 Vector s = new Vector(nombre, dimension, valorInicial);
		 t.put(nombre, s);
		 return s;
	}
	
	public Vector insertar(String nombre, Integer dimension, Integer dimension2, Object valorInicial){
		 Vector s = new Vector(nombre, dimension, dimension2, valorInicial);
		 t.put(nombre, s);
		 return s;
	}
	
	public Vector buscar(String nombre){
		 return (Vector)(t.get(nombre));
	}
	
	public void imprimir(){
		 Iterator it = t.values().iterator();
		 while(it.hasNext()){
			 Vector s = (Vector)it.next();
			 
			 if (s.getObject(0) == null) System.out.print("i: Indefinido");
			 
			 else if (s.getObject(0) instanceof Double) System.out.print("VECTOR Real "+ s.nombre +"["+s.dimension1+"]" );
			 else if (s.getObject(0) instanceof Integer) System.out.print("VECTOR Entero "+ s.nombre +"["+s.dimension1+"]" );
			 else if (s.getObject(0) instanceof Character) System.out.print("VECTOR Char "+ s.nombre +"["+s.dimension1+"]");
			 else if (s.getObject(0) instanceof Boolean) System.out.print("VECTOR Booleano "+ s.nombre +"["+s.dimension1+"]");
			 System.out.println();
		 }
	 }
	
	
	
	
	
    
    
}