package lex.manual; // paquete en el que creemos el archivo

import lex.generado.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


class Driver {
	public static void main(String args[]) throws IOException {
	// Entrada de datos: teclado por defecto, fichero si hay argumento
	InputStream dataStream = System.in;
	
	if (args.length >= 1) {
		System.out.println("Leyendo entrada de fichero... ");
		
		dataStream = new FileInputStream(args[0]);
	} else {
	System.out.println("Inserta expresiones a reconocer pulsando <ENTER> entre ellas");
	}
	
	// Creamos el objeto scanner
	Lexer scanner = new Lexer(dataStream);
	ArrayList<Symbol> symbols = new ArrayList<Symbol>();
	ArrayList<Integer> token_types = new ArrayList<Integer>();
	ArrayList<Object> token_value = new ArrayList<Object>();
	

	
	// Mientras no alcancemos el fin de la entrada
	boolean end = false;
	while (!end) {
		try {
			Symbol token = scanner.next_token();
			symbols.add(token);
			end = (token.value() == null);
			token_types.add(token.type());
			token_value.add(token.value());
			
			/*if (!end) {
				 System.out.println("Encontrado: {" + token.type() + " - "+SimbolosTerminales.terminalNames[token.type()]+ "} >> " + token.value());
			 }*/
		} catch (Exception x) {
		System.out.println("Ups... algo ha ido mal");
		x.printStackTrace();
		}
	}
	symbols.trimToSize();
	// Lo utilizo para recorrer todos los simbolos terminales
	for ( int i = 2; i < 17; i++) {
		for ( int j = 0; j < token_types.size(); j++ ) {
			if(token_types.get(j) == i) {
				 System.out.println("Encontrado: {" + token_types.get(j) + " - "+SimbolosTerminales.terminalNames[token_types.get(j)]+ "} >> " + token_value.get(j));	
			}
		}
	}
	
	System.out.println("\nNumero de tokens: " + symbols.size());
	System.out.println("\n\n -- Bye-bye -- ");
	}
}

