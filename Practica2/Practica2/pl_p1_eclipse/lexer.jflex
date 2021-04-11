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

Newline    		    = \r | \n | \r\n
Whitespace 		    = [ \t\f] | {Newline}

Variable			= "MEM"[0-9]

/* numbers */
Integer	    	   	= [0-9]+
Float 	   		   	= {Integer}? \. {Integer}
ScientificNotation 	= {Float} [eE] [\+\-]? {Integer} | {Integer} [eE] [\+\-]? {Integer}
Hexadecimal		   	= "0" [Xx] [0-9A-F]+

/* comments */
Comment 			= {TraditionalComment} | {EndOfLineComment} | {HTMLCommentTag} 
TraditionalComment 	= "/*" {CommentContent} \*+ "/" 
EndOfLineComment 	= "//" [^\r\n]* {Newline} 
CommentContent 		= ( [^*] | \*+[^*/] )*
HTMLCommentTag 		= "<!--" ~ "-->"


/* Author */
FullName 			= {Name} ([ ] {Name})+
Name				= ([A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*) (\-[A-Z¡…Õ”⁄][a-z·ÈÌÛ˙]*)*
Email				= [A-Za-z0-9\_\-]+ \@ ([A-Za-z0-9\_\-]+ \.)+ [A-Za-z0-9]+
DNI					= [0-9]{8} [A-Z]
Plate				= [0-9]{4} [ ]? [B-DF-HJ-—P-TV-Z]{3}
Date				= ([0-2][0-9]|(3)[0-1]) "/" (((0)[0-9])|((1)[0-2])) "/" [0-9]{4}

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {
  {Whitespace} 		    { 																										}
  {Comment}  			{ 																										}
  {FullName}  			{ System.out.println("Nombre y apellidos: " + yytext());												}
  {Email}	  			{ System.out.println("Email: " + yytext());																}
  {DNI}	  				{ System.out.println("DNI: " + yytext());																}
  {Plate}				{ System.out.println("MatrÌcula: " + yytext());															}
  {Date}	  			{ System.out.println("Fecha: " + yytext());																}
  ";"          			{ return symbolFactory.newSymbol("SEMI", 	SEMI); 														}
  "+"          			{ return symbolFactory.newSymbol("PLUS", 	PLUS); 														}
  "-"          			{ return symbolFactory.newSymbol("MINUS", 	MINUS); 													}
  "*"          			{ return symbolFactory.newSymbol("TIMES", 	TIMES); 													}
  "/"          			{ return symbolFactory.newSymbol("DIVIDED", DIVIDED); 													}
  "("          			{ return symbolFactory.newSymbol("LPAREN", 	LPAREN); 													}
  ")"          			{ return symbolFactory.newSymbol("RPAREN", 	RPAREN); 													}
  "exp"          		{ return symbolFactory.newSymbol("EXP", 	EXP); 														}
  "ln"          		{ return symbolFactory.newSymbol("LN", 		LN); 														}
  "="          			{ return symbolFactory.newSymbol("EQUALS", 	EQUALS); 													}
  {Variable}       		{ return symbolFactory.newSymbol("MEM", 	MEM,		Character.getNumericValue(yytext().charAt(3)));	}
  {Integer}     		{ return symbolFactory.newSymbol("NUMBER", 	NUMBER, 	Double.parseDouble(yytext())); 					}
  {Float}     			{ return symbolFactory.newSymbol("NUMBER", 	NUMBER, 	Double.parseDouble(yytext())); 					}
  {ScientificNotation}	{ return symbolFactory.newSymbol("NUMBER", 	NUMBER, 	Double.parseDouble(yytext())); 					}
  {Hexadecimal}			{ return symbolFactory.newSymbol("NUMBER", 	NUMBER, 	Long.decode(yytext()).doubleValue()); 			}
}

// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
