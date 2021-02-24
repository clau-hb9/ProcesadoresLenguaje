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

Hex         = "0x"[0-9|A-F]+        /* Macro for Hexadecimal numbers */
Real 		= ("+"|"-")? [0-9]+ ("." [0-9]+)?

/* Comentarios */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

/* Datos identificativos */

nombre_completo		= {Name} ({Whitespace} {Name})+
Name				= ([A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*) (\-[A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*)*
Email				= [A-Za-z0-9\_\-]+ \@ ([A-Za-z0-9\_\-]+ \.)+ [A-Za-z0-9]+
DNI					= [0-9]{8} [A-Z]
Matricula			= [0-9]{4} [ ]? [B-DF-HJ-—P-TV-Z]{3}
Fecha				= ([0-2][0-9]|(3)[0-1]) "/" (((0)[0-9])|((1)[0-2])) "/" [0-9]{4}


ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*




%state CODESEG

%%  

/* REGLAS PARA DETERTAR TOKENS Y ACCIONES ASOCIADAS */
<YYINITIAL> {

  	{Whitespace} 				{                              }
  	
  	/* Comentarios */
  	{Comment} 					{                              }
  	
  	/* NUMEROS */
	{Real}      				{ return new Symbol(SimbolosTerminales.NUMBER, 		Double.parseDouble(yytext()));			}
	{Hex}						{return new Symbol(SimbolosTerminales.HEXADECIMAL, 	Long.decode(yytext()).doubleValue()); 	}
	
	/* Datos identificativos */
	{DNI}						{return new Symbol(SimbolosTerminales.DNI,			yytext());}
	{nombre_completo}			{return new Symbol(SimbolosTerminales.NAME, 		yytext());}
	{Email}						{return new Symbol(SimbolosTerminales.EMAIL, 		yytext());}
	{Matricula}					{return new Symbol(SimbolosTerminales.MATRICULA, 	yytext());}
	{Fecha}						{return new Symbol(SimbolosTerminales.FECHA, 		yytext());}
	
	
	
	
	
	/* Operadores y separadores */
	
	";"          			{ return new Symbol(SimbolosTerminales.SEMI, 	yytext());	}
	"("          			{ return new Symbol(SimbolosTerminales.LPAREN, 	yytext()); 	}												
  	")"          			{ return new Symbol(SimbolosTerminales.RPAREN, 	yytext());	}
  	"="          			{ return new Symbol(SimbolosTerminales.EQUALS, 	yytext()); 	}
  	"+"          			{ return new Symbol(SimbolosTerminales.PLUS, 	yytext()); 	}													
  	"-"          			{ return new Symbol(SimbolosTerminales.MINUS, 	yytext()); 	}												
  	"*"          			{ return new Symbol(SimbolosTerminales.TIMES, 	yytext()); 	}												
  	"/"          			{ return new Symbol(SimbolosTerminales.DIVIDED, yytext());	}
  	
  	
  				

}



// error fallback
.|\n          {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar); }

