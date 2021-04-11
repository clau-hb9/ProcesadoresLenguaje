package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%


%class Lexer
%implements sym
%public
%unicode
%line 	
%column 
%char 	
			


%{
	public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
    public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
%}


%eofval{
	System.out.println("\nLeidas: "+yyline + " lineas, " + yychar + " caracteres");
    return new Symbol(EOF);
%eofval}




/*MACROS Y EXPRESIONES REGULARES*/
/*Espacios*/
Newline    = \r | \n | \r\n
Whitespace = [ \t\f] 

/*Numeros*/

Hex         = ("0X"|"0x") [0-9|A-F|a-f]+        /* Macro for Hexadecimal numbers */
Real 		= [0-9]+ ("." [0-9]+)? ((E|e)("+"|"-")? [0-9]+)?



/* Comentarios */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

/* Datos identificativos */

nombre_completo		= {Name}({Whitespace} {Name})+
Name				= ([A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*) ("-"[A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*)*
Email				= [A-Za-z0-9\_\-\.]+ \@ ([A-Za-z0-9\_\-]+ \.)+ ([a-z]{2,4})+
DNI					= [0-9]{8} [A-Za-z]
Matricula			= [0-9]{4} ({Whitespace}|"-")? [BCDFGHJKLMNPRSTVWXYZ]{3}
Fecha				= ([0-2][0-9] | 3[0-1]) "/" ( (0[0-9]) | (1[0-2])) "/" [0-9]{4}


ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*




%%  

/* REGLAS PARA DETERTAR TOKENS Y ACCIONES ASOCIADAS */
<YYINITIAL> {

  	{Whitespace} 				{                              }
  	{Newline} 					{                              }
  	
  	/* Comentarios */
  	{Comment} 					{                              }
  	
  	/* NUMEROS */
	{Real}      				{ return new Symbol(SimbolosTerminales.NUMBER, 		Double.parseDouble(yytext()));			}
	{Hex}						{return new Symbol(SimbolosTerminales.NUMBER, 		Long.decode(yytext()).doubleValue()); 	}
	
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
  	"+"          			{ return new Symbol(SimbolosTerminales.PLUS, 	yytext()); 	}													
  	"-"          			{ return new Symbol(SimbolosTerminales.MINUS, 	yytext()); 	}												
  	"*"          			{ return new Symbol(SimbolosTerminales.TIMES, 	yytext()); 	}												
  	"/"          			{ return new Symbol(SimbolosTerminales.DIVIDED, yytext());	}
  	
  	
  				

}



// error fallback
.|\n          {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar); }

