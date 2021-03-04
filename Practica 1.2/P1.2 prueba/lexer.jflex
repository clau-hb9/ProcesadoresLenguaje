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
	public int primer_miembro;
	public int segundo_miembro;
	public String operador="";
	
	public int sumar (int a, int b){
		return a+b;
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


Real 		= [0-9]





%%


<YYINITIAL>{

	{Whitespace} 				{                              }
  	{Newline} 					{                              }
  	
  	/* Comentarios */
  	{Comment} 					{                              	}
  	
  	{Real}      				{ yybegin(OPERACION);
  									primer_miembro = Integer.parseInt(yytext());
  								}
  	
}
 
<OPERACION>{
	{Newline} 					{                              	}
	{Whitespace} 				{                              	}
	"+" 						{	System.out.println(primer_miembro);
									operador += '+';
									yybegin(SEGUNDO_MIEMBRO);
								}
	"-" 						{ 	System.out.println("resta");
									yybegin(SEGUNDO_MIEMBRO);
								}

} 

<SEGUNDO_MIEMBRO>{
	{Newline} 					{                              	}
	{Whitespace} 				{                              	}
	{Real} 						{	segundo_miembro = Integer.parseInt(yytext());
									System.out.println(operador);
									yybegin(FINAL_OPERACION);
								}

}	

<FINAL_OPERACION>{
	{Newline} 					{                             	}
	{Whitespace} 				{                              	}
	";"							{	//if (operador.equals('+') ){
										int suma = sumar(primer_miembro, segundo_miembro);
										System.out.println(suma);
							
									//}
								}

}
	
  
/* Reglas para detectar los tokens y acciones asociadas */
// error fallback
.|\n {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " +(yycolumn+1) + " " + yychar); }
