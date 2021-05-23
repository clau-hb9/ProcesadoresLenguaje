package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;
import cup.example.tables.*;
import java.io.BufferedReader;

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
	
	private TablaSimbolos tabla;
	private TablaVectores tablaVectores;
	private Object entrada;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	

 	private static int actualEtq=0;
 	private static String nuevaEtq() {
 		return "etqL"+(++actualEtq);
 	}

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is, TablaSimbolos t, TablaVectores t1){
		this(is);
        symbolFactory = sf;
        this.tabla = t;
        this.tablaVectores = t1;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader, TablaSimbolos t, TablaVectores t1){
		this(reader);
        symbolFactory = sf;
        this.tabla = t;
        this.tablaVectores = t1;
        
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



/* Entrada */
Entero		= [0-9] | [1-9][0-9]+
Hex         = ("0X"|"0x") [0-9|A-F|a-f]+ 
Real 		= [0-9]+ "." ([0-9]+)?
Cientifica	= [1-9] ("." [0-9]+)? ((E|e)("+"|"-")? [0-9]+)
Caracter    = "'" .? "'"
ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*



/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*






/* Palabras reservadas */
%caseless Vector    	= "vector"
%caseless EnteroVar 	= "entero"
%caseless RealVar   	= "real"
%caseless Booleano  	= "booleano"
%caseless CaracterVar   = "caracter"

%caseless And       	= "and"
%caseless Or        	= "or"
%caseless Not       	= "not"

%caseless True      	= "true"
%caseless False     	= "falso"

%caseless While     	= "mientras"
%caseless EndWhile  	= "finmientras"
%caseless If        	= "si"
%caseless EndIf     	= "finsi"
%caseless Else      	= "sino"
%caseless Then      	= "entonces"

%caseless Entrada      	= "entrada"






%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {True}        	{ return symbolFactory.newSymbol("BOOLEAN",   	BOOLEAN, 	  	Boolean.parseBoolean(yytext())); 				}
<YYINITIAL> {False}       	{ return symbolFactory.newSymbol("BOOLEAN",   	BOOLEAN, 	  	Boolean.parseBoolean(yytext()));				}

/* Tipo Variables */
<YYINITIAL> {Vector}      	{ return symbolFactory.newSymbol("VECTOR", 	  	VECTOR); 															}
<YYINITIAL> {EnteroVar}     { return symbolFactory.newSymbol("VARTYPE",    	VARTYPE, 		yytext()); 											}
<YYINITIAL> {RealVar}     	{ return symbolFactory.newSymbol("VARTYPE",		VARTYPE, 		yytext());											}
<YYINITIAL> {Booleano}     	{ return symbolFactory.newSymbol("VARTYPE", 	VARTYPE, 		yytext());											}
<YYINITIAL> {CaracterVar}   { return symbolFactory.newSymbol("VARTYPE", 	VARTYPE, 		yytext());											}

/* Condicionales */
<YYINITIAL> {And}         	{ return symbolFactory.newSymbol("AND", 	    AND); 														    }
<YYINITIAL> {Or}          	{ return symbolFactory.newSymbol("OR", 	      	OR); 														    }
<YYINITIAL> {Not}         	{ return symbolFactory.newSymbol("NOT", 	    NOT); 															}	

/* Estructuras de control */
<YYINITIAL> {While}       	{ return symbolFactory.newSymbol("WHILE", 	  	WHILE, nuevaEtq()); 														}
<YYINITIAL> {EndWhile}   	{ return symbolFactory.newSymbol("ENDWHILE",  	ENDWHILE); 														}
<YYINITIAL> {EndIf}      	{ return symbolFactory.newSymbol("ENDIF", 	  	ENDIF); 														}
<YYINITIAL> {If}          	{ return symbolFactory.newSymbol("IF", 	      	IF, nuevaEtq() ); 														    }
<YYINITIAL> {Else}        	{ return symbolFactory.newSymbol("ELSE", 	    ELSE); 														    }
<YYINITIAL> {Then}        	{ return symbolFactory.newSymbol("THEN", 	    THEN); 															}

<YYINITIAL> {Entrada}       { entrada =  reader.readLine(); System.out.println(entrada);return symbolFactory.newSymbol("ENTRADA", 	    ENTRADA, entrada ); 															}


<YYINITIAL> {

  {Whitespace} {                              }
  /* Comentarios */
  	{Comment} 					{                              }
  ";"          				{ return symbolFactory.newSymbol("SEMI", 		SEMI); 															}
  ","          			    { return symbolFactory.newSymbol("COMA", 	  	COMA); 															}
  
  "+"          				{ return symbolFactory.newSymbol("PLUS", 		PLUS); 															}
  "-"          				{ return symbolFactory.newSymbol("MINUS", 		MINUS); 														}
  "*"          				{ return symbolFactory.newSymbol("TIMES", 		TIMES); 														}
  "/"         				{ return symbolFactory.newSymbol("DIVISION", 	DIVISION); 														}	
  "n"          				{ return symbolFactory.newSymbol("UMINUS", 		UMINUS); 														}
  ":="         				{ return symbolFactory.newSymbol("ASIGNACION", 	ASIGNACION);													}
  
  
  "("          				{ return symbolFactory.newSymbol("LPAREN", LPAREN); 															}
  ")"          				{ return symbolFactory.newSymbol("RPAREN", RPAREN); 															}
  "["          			    { return symbolFactory.newSymbol("LBRACKET",  	LBRACKET); 													    }
  "]"          			    { return symbolFactory.newSymbol("RBRACKET",  	RBRACKET); 													    }
  
  /* Comparaci�n */
  "<"          		  	    { return symbolFactory.newSymbol("MENORQUE", 	MENORQUE); 														}														  
  ">"          			    { return symbolFactory.newSymbol("MAYORQUE", 	MAYORQUE); 														}
  "=="         			    { return symbolFactory.newSymbol("IGUALQUE", 	IGUALQUE);														}
  
  
  
    /* L�gico */
  "&"						{ return symbolFactory.newSymbol("AND", 	    AND);															}
  "|"						{ return symbolFactory.newSymbol("OR", 	        OR);															}
  "!"						{ return symbolFactory.newSymbol("NOT", 	    NOT);															}
  
  
  
  {Entero}     		    	{ return symbolFactory.newSymbol("ENTERO",   	ENTERO, 	  		Integer.parseInt(yytext()));					}
  {Hex}			    		{ return symbolFactory.newSymbol("ENTERO",   	ENTERO, 	  		Long.decode(yytext()).intValue());			}
  {Real}      				{ return symbolFactory.newSymbol("REAL", 	    REAL, 	    		Double.parseDouble(yytext())); 					}
  {Cientifica}	  			{ return symbolFactory.newSymbol("REAL",  		REAL, 				Double.parseDouble(yytext())); 					}
  {Caracter}	            { return symbolFactory.newSymbol("CARACTER", 	CARACTER, 			yytext().charAt(1)); 					        }
  
  
  
  
  
  
  
  {ident}      				{ Simbolo s ;
			  				if (( s = tabla.buscar(yytext())) == null){
			  					s = tabla.insertar(yytext());
			  				}
			  				return symbolFactory.newSymbol("IDENT",     	IDENT, s );	    }	
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
