package lex.manual;


public interface SimbolosTerminales {
		 /* terminals */
		 public static final int EOF = 0;
		 public static final int error = 1;
		 public static final int NUMBER = 2;
		 public static final int DNI = 3;
		 public static final int NAME = 4;
		 public static final int EMAIL = 5;
		 public static final int MATRICULA = 6;
		 public static final int FECHA = 7;
		 public static final int HEXADECIMAL = 8;
		 public static final int SEMI = 9;
		 public static final int LPAREN = 10;
		 public static final int RPAREN = 11;
		 public static final int EQUALS = 12;
		 public static final int PLUS = 13;
		 public static final int MINUS = 14;
		 public static final int TIMES = 15;
		 public static final int DIVIDED = 16;
			  
	
		 /* lista de nombres, util para devolver información por pantalla */
		 public static final String[] terminalNames = new String[] {
		 "EOF",
		 "error",
		 "NUMBER",
		 "DNI",
		 "NAME",
		 "EMAIL",
		 "MATRICULA",
		 "FECHA",
		 "HEXADECIMAL",
		 "SEMI",
		 "LPAREN",
		 "RPAREN",
		 "EQUALS",
		 "PLUS",
		 "MINUS",
		 "TIMES",
		 "DIVIDED"
		 
		
		 };

}