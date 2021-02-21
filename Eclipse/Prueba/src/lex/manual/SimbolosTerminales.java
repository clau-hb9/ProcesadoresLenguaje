package lex.manual;


public interface SimbolosTerminales {
		 /* terminals */
		 public static final int EOF = 0;
		 public static final int error = 1;
		 public static final int SEMI = 2;
		 public static final int PLUS = 3;
		 public static final int MINUS = 4;
		 public static final int TIMES = 5;
		 public static final int LPAREN = 6;
		 public static final int RPAREN = 7;
		 public static final int NUMBER = 8;
		 public static final int LETRA = 9;
		// public static final int nombre = 2;
		// public static final int numero = 3;
		// …

		 /* lista de nombres, util para devolver información por pantalla */
		 public static final String[] terminalNames = new String[] {
		 "EOF",
		 "error",
		 "SEMI",
		 "PLUS",
		 "MINUS",
		 "TIMES",
		 "LPAREN",
		 "RPAREN",
		 "NUMBER",
		 "LETRA"
		 
		// ,"nombre",
		// "numero"
		//....
		 };

}