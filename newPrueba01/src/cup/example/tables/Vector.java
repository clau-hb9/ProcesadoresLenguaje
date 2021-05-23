package cup.example.tables;

import java.util.ArrayList;

public class Vector {

    public String nombre;
    public ArrayList<Object> array;
    public Integer dimension1;
    public Integer dimension2;

    public Vector(String nombre, int dimension1, Object valorInicial){
    	 this.nombre = nombre;
    	 this.array = new ArrayList<Object> ();
    	 this.dimension1 = dimension1;
    	 for ( int i = 0 ; i< dimension1; i++) {
    		 this.array.add(valorInicial);
    	 }
    }
    
    public Vector(String nombre, int dimension1, int dimension2, Object valorInicial){
   	 this.nombre = nombre;

   	this.array = new ArrayList<Object> ();
   	this.dimension1 = dimension1;
   	this.dimension2 = dimension2;
   	for ( int i = 0 ; i< dimension1; i++) {
		 //this.array.add(valorInicial);
		 for ( int j= 0; j< dimension2; j++) {
			 ((ArrayList<Object>) this.array.get(i)).add(valorInicial);
		 }
	 }
   }

    public Object getObject (int dimension1) {
    	
    	return this.array.get(dimension1);
    	
    }
    
    public void setValue (Object value, int dimension1) {
    	
    	this.array.add(dimension1, value);
    }
 

    
    public void imprimir() {
    	System.out.println("empiezo a escribir");
	    for(int i=0; i < this.array.size(); i++){
	        System.out.println( this.array.get(i) );
	    }
    System.out.println();
    }
    
}
