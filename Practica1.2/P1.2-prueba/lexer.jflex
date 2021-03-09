package src.lex.generado; // paquete en el que se genera el fichero java
import src.lex.manual.SimbolosTerminales; //Simbolos terminales definidos
import src.lex.manual.Symbol;



%%



%class Lexer
%implements SimbolosTerminales
%public
%unicode
%line
%column
%char
%function next_token 
 
%type Symbol 
%state  OPERACION, SEGUNDO_MIEMBRO, FINAL_OPERACION



%{
	 int primer_miembro;
	 int segundo_miembro;
	 String operador="";
	
	
	public int sumar (int a, int b){
		return a+b;
	}
	
	public int restar (int a, int b){
		return a-b;
	}
	
	public int multiplicar (int a, int b){
		return a*b;
	}
	
	public int dividir (int a, int b){
		return a/b;
	}

%}


%eofval{
 return new Symbol(EOF);
%eofval}

/* Macros para expresiones regulares (para simplificar reglas) */
/*Espacios*/
Newline    = \r | \n | \r\n
Whitespace = [ \t\f] 
/* Comentarios */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*


Real 		= "-"? [0-9]+





%%



<YYINITIAL>{

	{Whitespace} 				{                              }
  	{Newline} 					{                              }
  	
  	
  	{Comment} 					{                              	}
  	
  	{Real}      				{ 	yybegin(OPERACION);
  									primer_miembro = Integer.parseInt(yytext());
  									
  								}
  	
  	
}
<OPERACION>{
	{Newline} 					{                              	}
	{Whitespace} 				{                              	}
	{Comment} 					{                              	}
	"+" 						{	
									operador = "+";
									yybegin(SEGUNDO_MIEMBRO);
								}
	"-" 						{ 	
									operador = "-";
									yybegin(SEGUNDO_MIEMBRO);
								}
	"*" 						{ 	
									operador = "*";
									yybegin(SEGUNDO_MIEMBRO);
								}
	"/" 						{ 	
									operador = "/";
									yybegin(SEGUNDO_MIEMBRO);
								}
	";"							{	System.out.println("RESULTADO: "+ primer_miembro);
									yybegin(YYINITIAL);
								}
	

} 

<SEGUNDO_MIEMBRO>{
	{Newline} 					{                              	}
	{Whitespace} 				{                              	}
	{Comment} 					{                              	}
	{Real} 						{	segundo_miembro = Integer.parseInt(yytext());
									if (operador.equals("+") ){
										int suma = sumar(primer_miembro, segundo_miembro);
										primer_miembro = suma;
										
										yybegin(OPERACION);
							
									}
									if (operador.equals("-")){
										int resta = restar(primer_miembro, segundo_miembro);
										primer_miembro = resta;
										
										
										yybegin(OPERACION);
							
									}
									if (operador.equals("*")){
										int multiplicacion = multiplicar(primer_miembro, segundo_miembro);
										primer_miembro = multiplicacion;
										
										yybegin(OPERACION);
							
									}
									
									if (operador.equals("/")){
										int division = dividir(primer_miembro, segundo_miembro);
										primer_miembro = division;
										
										yybegin(OPERACION);
							
									}
								}
								

}







	
  
/* Reglas para detectar los tokens y acciones asociadas */
// error fallback
.|\n {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " +(yycolumn+1) + " " + yychar); }
