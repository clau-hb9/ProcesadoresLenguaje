package src.lex.manual; // paquete en el que creemos el archivo
import src.lex.generado.*;
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
				System.out.println("Inserta expresiones a reconocer,pulsando <ENTER> entre ellas");
			}
			// Creamos el objeto scanner
			Lexer scanner = new Lexer(dataStream);
			ArrayList<Symbol> symbols = new ArrayList<Symbol>();
			// Mientras no alcancemos el fin de la entrada
			boolean end = false;
			
			System.out.println("\n\n -- Mostramos los resultados de la operación al completo -- ");
			while (!end) {
				
				try {
					Symbol token = scanner.next_token();
					symbols.add(token);
					end = (token.value() == null);
				
				} catch (Exception x) {
					System.out.println("Ups... algo ha ido mal");
					x.printStackTrace();
				}
				}
			
			symbols.trimToSize();
			System.out.println("\n\n -- Bye-bye -- ");
			}
}