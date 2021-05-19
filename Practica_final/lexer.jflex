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




Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}


/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*



/* Numeros */
Entero		= [0-9] | [1-9][0-9]+
Hex         = ("0X"|"0x") [0-9|A-F|a-f]+        /* Macro for Hexadecimal numbers */
Real 		= [0-9]+ "." ([0-9]+)?
Cientifica	= [1-9] ("." [0-9]+)? ((E|e)("+"|"-")? [0-9]+)
Caracter    = "'" .? "'"





/* Palabras reservadas */
%caseless True      	= "true"
%caseless False     	= "false"
%caseless Vector    	= "vector"
%caseless EnteroVar 	= "entero"
%caseless RealVar   	= "real"
%caseless Booleano  	= "booleano"
%caseless CaracterVar   = "caracter"
%caseless While     	= "mientras"
%caseless EndWhile  	= "finmientras"
%caseless If        	= "si"
%caseless EndIf     	= "finsi"
%caseless Else      	= "sino"
%caseless Then      	= "entonces"
%caseless And       	= "and"
%caseless Or        	= "or"
%caseless Not       	= "not"
/*%caseless Entrada		= "entrada"*/

/*
%caseless Function  	= "funcion"
%caseless Return    	= "return"
*/


/* Identificador */
ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  
																/* PALABRAS RESERVADAS */
																

<YYINITIAL> {True}        	{ return symbolFactory.newSymbol("BOOLEAN",   	BOOLEAN, 	  	yytext()); 				}
<YYINITIAL> {False}       	{ return symbolFactory.newSymbol("BOOLEAN",   	BOOLEAN, 	  	yytext());				}


/* Tipo Variables */
<YYINITIAL> {Vector}      	{ return symbolFactory.newSymbol("VECTOR", 	  	VECTOR); 														}
<YYINITIAL> {EnteroVar}     { return symbolFactory.newSymbol("VARTYPE",    	VARTYPE, 		yytext()); 											}
<YYINITIAL> {RealVar}     	{ return symbolFactory.newSymbol("VARTYPE",		VARTYPE, 		yytext());											}
<YYINITIAL> {Booleano}     	{ return symbolFactory.newSymbol("VARTYPE", 	VARTYPE, 		yytext());											}
<YYINITIAL> {CaracterVar}   { return symbolFactory.newSymbol("VARTYPE", 	VARTYPE, 		yytext());											}




/* Estructuras de control */
<YYINITIAL> {While}       	{ return symbolFactory.newSymbol("WHILE", 	  	WHILE); 														}
<YYINITIAL> {EndWhile}   	{ return symbolFactory.newSymbol("ENDWHILE",  	ENDWHILE); 														}
<YYINITIAL> {EndIf}      	{ return symbolFactory.newSymbol("ENDIF", 	  	ENDIF); 														}
<YYINITIAL> {If}          	{ return symbolFactory.newSymbol("IF", 	      	IF); 														    }
<YYINITIAL> {Else}        	{ return symbolFactory.newSymbol("ELSE", 	    ELSE); 														    }
<YYINITIAL> {Then}        	{ return symbolFactory.newSymbol("THEN", 	    THEN); 															}

/* Condicionales */
<YYINITIAL> {And}         	{ return symbolFactory.newSymbol("AND", 	    AND); 														    }
<YYINITIAL> {Or}          	{ return symbolFactory.newSymbol("OR", 	      	OR); 														    }
<YYINITIAL> {Not}         	{ return symbolFactory.newSymbol("NOT", 	    NOT); 															}	

/*<YYINITIAL> {Entrada}    	{ return symbolFactory.newSymbol("ENTRADA",  	ENTRADA); 														}*/



<YYINITIAL> {

  {Whitespace} 				{                              																					}
  {Comment}  			  	{ 																										        }
  
  /* Aritmetico */
  ";"          				{ return symbolFactory.newSymbol("SEMI", 		SEMI); 															}
  "+"          				{ return symbolFactory.newSymbol("PLUS", 		PLUS); 															}
  "-"          				{ return symbolFactory.newSymbol("MINUS", 		MINUS); 														}
  "*"          				{ return symbolFactory.newSymbol("TIMES", 		TIMES); 														}
  "/"         				{ return symbolFactory.newSymbol("DIVISION", 	DIVISION); 														}
  "n"          				{ return symbolFactory.newSymbol("UMINUS", 		UMINUS); 														}
  
  
  "."						{ return symbolFactory.newSymbol("PUNTO", 	    PUNTO); 														}
  ","          			    { return symbolFactory.newSymbol("COMA", 	  	COMA); 															}
  "["          			    { return symbolFactory.newSymbol("LBRACKET",  	LBRACKET); 													    }
  "]"          			    { return symbolFactory.newSymbol("RBRACKET",  	RBRACKET); 													    }
  "("          				{ return symbolFactory.newSymbol("LPAREN", 		LPAREN); 														}
  ")"          				{ return symbolFactory.newSymbol("RPAREN", 		RPAREN); 														}
  ":="         				{ return symbolFactory.newSymbol("ASIGNACION", 	ASIGNACION);													}
  
  /* Comparación */
  "<"          		  	    { return symbolFactory.newSymbol("MENORQUE", 	MENORQUE); 														}														  
  ">"          			    { return symbolFactory.newSymbol("MAYORQUE", 	MAYORQUE); 														}
  "=="         			    { return symbolFactory.newSymbol("IGUALQUE", 	IGUALQUE); 														}
  "<="          			{ return symbolFactory.newSymbol("MENORIGQUE", 	MENORIGQUE); 												    }
  ">="          			{ return symbolFactory.newSymbol("MAYORIGQUE",  MAYORIGQUE); 													}
  
  /* Lógico */
  "&"						{ return symbolFactory.newSymbol("AND", 	    AND);															}
  "|"						{ return symbolFactory.newSymbol("OR", 	        OR);															}
  "!"						{ return symbolFactory.newSymbol("NOT", 	    NOT);															}
  
  
  /* Numbers */
  {Entero}     		    	{ return symbolFactory.newSymbol("ENTERO",   	ENTERO, 	  	Double.parseDouble(yytext()));					}
  {Hex}			    		{ return symbolFactory.newSymbol("ENTERO",   	ENTERO, 	  	Long.decode(yytext()).doubleValue());				}
  {Real}      				{ return symbolFactory.newSymbol("REAL", 	    REAL, 	    	Double.parseDouble(yytext())); 					}
  {Cientifica}	  			{ return symbolFactory.newSymbol("REAL",  		REAL, 			Double.parseDouble(yytext())); 					}
  {Caracter}	            { return symbolFactory.newSymbol("CARACTER", 	CARACTER, 		yytext()); 					        }
  
  /* Identificador 	*/
  {ident}     		    	{ return symbolFactory.newSymbol("IDENT",     	IDENT, 	    		yytext()); 					                }
  
  
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
