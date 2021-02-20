package lex.generado;
import lex.manual.SimbolosTerminales; 
import lex.manual.Symbol;

%%


%class Lexer
%implements SimbolosTerminales
%public
%unicode

%line
%column
%char

%function next_token /*Nombre del metodo que escanea la entrada y devuelve el siguiente token*/
%type Symbol /*Tipo de retorno para la funcion scan*/

%eofval{
    return new Symbol(EOF);
%eofval}


/*MACROS Y EXPRESIONES REGULARES*/
Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Integer		= [0-9]+


/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*




%state CODESEG

%%  

/* REGLAS PARA DETERTAR TOKENS Y ACCIONES ASOCIADAS */
/*<YYINITIAL> {

  {Whitespace} {                              }
  {Comment} {                              }
  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
  "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
  "n"          { return symbolFactory.newSymbol("UMINUS", UMINUS); }
  "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
  ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
{Integer}      { return symbolFactory.newSymbol("NUMBER", 	NUMBER, 	Integer.parseInt(yytext())); 					}

}*/



// error fallback
.|\n          {System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar); }

