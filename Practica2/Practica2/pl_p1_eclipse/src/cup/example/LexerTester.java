package cup.example;

import java.io.*;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;

class LexerTester {

	public static void main(String[] args) throws Exception {
		
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
		
		boolean endOfFile = false;
		while (!endOfFile) {
			try {
				Symbol token = scanner.next_token();
				symbols.add(token);
				endOfFile = token.sym == 0;
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		
		symbols.trimToSize();
		System.out.println("\nNumero de tokens:" + symbols.size());
		
		for (Symbol symbol : symbols) {
			System.out.println("Almacenado: [" + symbol.sym + " / " + sym.terminalNames[symbol.sym] + "]");
			if (symbol.value != null) System.out.println("Valor: " + symbol.value.toString());
		}
	}
	
}