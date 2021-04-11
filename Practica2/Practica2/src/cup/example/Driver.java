package cup.example;

import java.io.*;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.*;

class Driver {

	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		parser.parse();
		
		ComplexSymbolFactory complexSymbolFactory = new ComplexSymbolFactory();
		
		File file = new File("input.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Lexer scanner = new Lexer(complexSymbolFactory, fileInputStream);
		ArrayList<Symbol> symbols = new ArrayList<Symbol>();
		
		boolean end = false;
		while (!end) {
			try {
				Symbol token = scanner.next_token();
				symbols.add(token);
				end = (token.sym == 0);
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		symbols.trimToSize();
		System.out.println("\n\n -- Bye-bye -- ");
		
		/*Parser parser = new Parser();
		parser.parse();*/
	}
	
}