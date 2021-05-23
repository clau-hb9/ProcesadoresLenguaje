package cup.example.tables;

import java.util.*;



/* Almacenamiento de las variables de tipo vector */
public class TablaSimbolos {

	HashMap t;
	
	public TablaSimbolos(){
		 t = new HashMap();
	 }

	public Simbolo insertar(String nombre){
		 Simbolo s = new Simbolo(nombre, null);
		 t.put(nombre, s);
		 return s;
	}
	
	
	
	public Simbolo buscar(String nombre){
		 return (Simbolo)(t.get(nombre));
	}
	
	public void imprimir(){
		 Iterator it = t.values().iterator();
		 while(it.hasNext()){
			 Simbolo s = (Simbolo)it.next();
			 if (s.cte == true) {
			 
			 if (s.valor == null) System.out.print( s.nombre +" i: Indefinido");
			 
				 else if (s.valor instanceof Double) System.out.print("Real "+ s.nombre +": "+ s.valor.toString());
				 else if (s.valor instanceof Integer) System.out.print("Entero "+ s.nombre  +": "+ s.valor.toString());
				 else if (s.valor instanceof Character) System.out.print("Char "+ s.nombre  +": "+ s.valor);
				 else if (s.valor instanceof Boolean) System.out.print("Booleano "+ s.nombre  +": "+  s.valor);
				 
				 System.out.println();
			 }
		 }
	 }
	
	
	
	
	
    
    
}