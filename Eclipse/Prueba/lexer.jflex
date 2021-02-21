package lex.generado;
import lex.manual.SimbolosTerminales; 
import lex.manual.Symbol;

%%


%class Lexer
%implements SimbolosTerminales
%public
%unicode

%line 	/*Cuenta las lineas. yyline devuelve las lineas desde principio hasta token*/
%column /*Columnas. yycolumn*/
%char 	/*Cuenta los caracteres. yychar te devuelve el numero de caracteres contados desde el principio hasta donde este el token*/

%function next_token 	/*Nombre del metodo que escanea la entrada y devuelve el siguiente token*/
%type Symbol 			/*Tipo de retorno para la funcion scan*/

/*Valores y codigo que se va a ejecutar cuando se llegue al final del fichero*/
%eofval{
    return new Symbol(EOF);
%eofval}


/*MACROS Y EXPRESIONES REGULARES*/
/*Espacios*/
Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}

/*Numeros*/

/*Hex         = "0x"[0-9|A-F]+*/        /* Macro for Hexadecimal numbers */
Real 		= [0-9]+ ("." [0-9]+)?

/* Comentarios */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

/* Datos identificativos */
/*FullName 			= {Name} ({Whitespace} {Name})+
Name				= ([A-Z�����][a-z�����]*) (\-[A-Z�����][a-z�����]*)*
Email				= [A-Za-z0-9\_\-]+ \@ ([A-Za-z0-9\_\-]+ \.)+ [A-Za-z0-9]+
DNI					= [0-9]{8} [A-Z]
Matricula			= [0-9]{4} [ ]? [B-DF-HJ-�P-TV-Z]{3}
Date				= ([0-2][0-9]|(3)[0-1]) "/" (((0)[0-9])|((1)[0-2])) "/" [0-9]{4}*/


ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*




%state CODESEG

%%  

/* REGLAS PARA DETERTAR TOKENS Y ACCIONES ASOCIADAS */
<YYINITIAL> {

  {Whitespace} {                              }
  {Comment} {                              }
  ";"          { return new Symbol(SimbolosTerminales.SEMI); }
  "+"          { return new Symbol(SimbolosTerminales.PLUS); }
  "-"          { return new Symbol(SimbolosTerminales.MINUS); }
  "*"          { return new Symbol(SimbolosTerminales.TIMES); }
/*  "n"          { return new Symbol(SimbolosTerminales.UMINUS); }*/
  "("          { return new Symbol(SimbolosTerminales.LPAREN); }
  ")"          { return new Symbol(SimbolosTerminales.RPAREN); }
{Real}      	{ return new Symbol(SimbolosTerminales.NUMBER, Double.parseDouble(yytext()));}
/*{Hex}			{return new Symbol(SimbolosTerminales.NUMBER, Long.decode(yytext()).doubleValue()); }*/

  				

}



// error fallback
.|\n          {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar); }

