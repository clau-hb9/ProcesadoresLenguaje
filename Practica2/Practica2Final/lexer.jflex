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
%cup
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
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

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

varMEM			= "MEM[" {number} "]"
number 			= [0-9]+

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*



%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {
	{Whitespace} 				{                              }
  	{Newline} 					{                              }	

  /* Comentarios */
  	{Comment} 					{                              }
  	
  /* NUMEROS */
	{Real}      				{ return symbolFactory.newSymbol("NUMBER", sym.NUMBER, Double.parseDouble(yytext()));			}
	{Hex}						{return symbolFactory.newSymbol("NUMBER", sym.NUMBER, Long.decode(yytext()).doubleValue()); 	}
	 
	/* Operadores y separadores */
	  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
	  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
	  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
	  "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
	  "/"		   { return symbolFactory.newSymbol("DIVIDED",DIVIDED);}
	  "n"          { return symbolFactory.newSymbol("UMINUS", UMINUS); }
	  "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
	  ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
	  
	/*Nuevos sÌmbolos*/
	"exp"          	{ return symbolFactory.newSymbol("EXP", 	EXP);  }
	"log"          	{ return symbolFactory.newSymbol("LOG", 	LOG);  }
	"cos"          	{ return symbolFactory.newSymbol("COS", 	COS);  }
	"sin"          	{ return symbolFactory.newSymbol("SIN", 	SIN);  }
	{varMEM}		{ 
					  return symbolFactory.newSymbol("MEM", 	MEM, Integer.parseInt(yytext().substring(4,yytext().length()-1))); }
	"="          	{ return symbolFactory.newSymbol("EQUALS", EQUALS); }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
