/* The following code was generated by JFlex 1.3.5 on 11/4/21 11:24 */

package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 11/4/21 11:24 from the specification file
 * <tt>file:/C:/Users/claud/Documents/UNIVERSIDAD/05_Quinto/Segundo_cuatri/Procesadores_Lenguaje/Github-Lazaro/ProcesadoresLenguaje/Practica2/Practica2/lexer.jflex</tt>
 */
public class Lexer implements sym {

  /** This character denotes the end of file */
  final public static int YYEOF = -1;

  /** initial size of the lookahead buffer */
  final private static int YY_BUFFERSIZE = 16384;

  /** lexical states */
  final public static int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  final private static String yycmap_packed = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\16\0\4\0\1\3\3\0"+
    "\1\0\3\0\1\36\1\37\1\17\1\14\1\0\1\15\1\11\1\16"+
    "\1\4\1\34\1\32\1\33\6\10\1\0\1\35\4\0\1\27\1\21"+
    "\3\30\1\12\1\30\2\31\1\25\5\31\1\25\1\31\1\25\3\31"+
    "\1\25\2\31\1\5\2\31\4\0\1\24\1\0\4\23\1\13\1\23"+
    "\21\26\1\6\2\26\1\0\1\7\2\0\41\0\2\0\4\0\4\0"+
    "\1\0\2\0\1\0\7\0\1\0\4\0\1\0\5\0\1\0\1\20"+
    "\7\0\1\20\3\0\1\20\5\0\1\20\3\0\1\0\2\0\1\20"+
    "\6\0\1\22\7\0\1\22\3\0\1\22\5\0\1\22\3\0\1\0"+
    "\2\0\1\22\u01c7\0\4\0\14\0\16\0\5\0\7\0\1\0\1\0"+
    "\1\0\21\0\160\0\5\0\1\0\2\0\2\0\4\0\1\0\1\0"+
    "\6\0\1\0\1\0\3\0\1\0\1\0\1\0\24\0\1\0\123\0"+
    "\1\0\213\0\1\0\5\0\2\0\246\0\1\0\46\0\2\0\1\0"+
    "\6\0\51\0\6\0\1\0\1\0\55\0\1\0\1\0\1\0\2\0"+
    "\1\0\2\0\1\0\1\0\10\0\33\0\4\0\4\0\15\0\6\0"+
    "\5\0\1\0\4\0\13\0\1\0\1\0\3\0\53\0\37\0\4\0"+
    "\2\0\1\0\143\0\1\0\1\0\10\0\1\0\6\0\2\0\2\0"+
    "\1\0\4\0\2\0\12\0\3\0\2\0\1\0\17\0\1\0\1\0"+
    "\1\0\36\0\33\0\2\0\131\0\13\0\1\0\16\0\12\0\41\0"+
    "\11\0\2\0\4\0\1\0\2\0\1\0\30\0\4\0\1\0\11\0"+
    "\1\0\3\0\1\0\5\0\22\0\31\0\3\0\4\0\13\0\65\0"+
    "\25\0\1\0\22\0\13\0\61\0\66\0\3\0\1\0\22\0\1\0"+
    "\7\0\12\0\2\0\2\0\12\0\1\0\20\0\3\0\1\0\10\0"+
    "\2\0\2\0\2\0\26\0\1\0\7\0\1\0\1\0\3\0\4\0"+
    "\2\0\1\0\1\0\7\0\2\0\2\0\2\0\3\0\1\0\10\0"+
    "\1\0\4\0\2\0\1\0\3\0\2\0\2\0\12\0\4\0\7\0"+
    "\2\0\1\0\1\0\2\0\3\0\1\0\6\0\4\0\2\0\2\0"+
    "\26\0\1\0\7\0\1\0\2\0\1\0\2\0\1\0\2\0\2\0"+
    "\1\0\1\0\5\0\4\0\2\0\2\0\3\0\3\0\1\0\7\0"+
    "\4\0\1\0\1\0\7\0\14\0\3\0\1\0\13\0\3\0\1\0"+
    "\11\0\1\0\3\0\1\0\26\0\1\0\7\0\1\0\2\0\1\0"+
    "\5\0\2\0\1\0\1\0\10\0\1\0\3\0\1\0\3\0\2\0"+
    "\1\0\17\0\2\0\2\0\2\0\12\0\1\0\1\0\7\0\1\0"+
    "\6\0\1\0\3\0\1\0\10\0\2\0\2\0\2\0\26\0\1\0"+
    "\7\0\1\0\2\0\1\0\5\0\2\0\1\0\1\0\7\0\2\0"+
    "\2\0\2\0\3\0\7\0\3\0\4\0\2\0\1\0\3\0\2\0"+
    "\2\0\12\0\1\0\1\0\20\0\1\0\1\0\1\0\6\0\3\0"+
    "\3\0\1\0\4\0\3\0\2\0\1\0\1\0\1\0\2\0\3\0"+
    "\2\0\3\0\3\0\3\0\14\0\4\0\5\0\3\0\3\0\1\0"+
    "\4\0\2\0\1\0\6\0\1\0\16\0\12\0\11\0\1\0\6\0"+
    "\5\0\10\0\1\0\3\0\1\0\27\0\1\0\20\0\3\0\1\0"+
    "\7\0\1\0\3\0\1\0\4\0\7\0\2\0\1\0\3\0\5\0"+
    "\2\0\2\0\2\0\12\0\20\0\1\0\3\0\1\0\10\0\1\0"+
    "\3\0\1\0\27\0\1\0\12\0\1\0\5\0\2\0\1\0\1\0"+
    "\7\0\1\0\3\0\1\0\4\0\7\0\2\0\7\0\1\0\1\0"+
    "\2\0\2\0\2\0\12\0\1\0\2\0\15\0\4\0\11\0\1\0"+
    "\3\0\1\0\51\0\2\0\1\0\7\0\1\0\3\0\1\0\4\0"+
    "\1\0\5\0\3\0\1\0\7\0\3\0\2\0\2\0\12\0\12\0"+
    "\6\0\1\0\3\0\1\0\22\0\3\0\30\0\1\0\11\0\1\0"+
    "\1\0\2\0\7\0\3\0\1\0\4\0\6\0\1\0\1\0\1\0"+
    "\10\0\6\0\12\0\2\0\2\0\15\0\60\0\1\0\2\0\7\0"+
    "\4\0\10\0\10\0\1\0\12\0\47\0\2\0\1\0\1\0\1\0"+
    "\5\0\1\0\30\0\1\0\1\0\1\0\12\0\1\0\2\0\11\0"+
    "\1\0\2\0\5\0\1\0\1\0\1\0\6\0\2\0\12\0\2\0"+
    "\4\0\40\0\1\0\27\0\2\0\6\0\12\0\13\0\1\0\1\0"+
    "\1\0\1\0\1\0\4\0\2\0\10\0\1\0\44\0\4\0\24\0"+
    "\1\0\2\0\5\0\13\0\1\0\44\0\11\0\1\0\71\0\53\0"+
    "\24\0\1\0\12\0\6\0\6\0\4\0\4\0\3\0\1\0\3\0"+
    "\2\0\7\0\3\0\4\0\15\0\14\0\1\0\17\0\2\0\46\0"+
    "\1\0\1\0\5\0\1\0\2\0\53\0\1\0\u014d\0\1\0\4\0"+
    "\2\0\7\0\1\0\1\0\1\0\4\0\2\0\51\0\1\0\4\0"+
    "\2\0\41\0\1\0\4\0\2\0\7\0\1\0\1\0\1\0\4\0"+
    "\2\0\17\0\1\0\71\0\1\0\4\0\2\0\103\0\2\0\3\0"+
    "\40\0\20\0\20\0\126\0\2\0\6\0\3\0\u026c\0\2\0\21\0"+
    "\1\0\32\0\5\0\113\0\3\0\13\0\7\0\15\0\1\0\4\0"+
    "\3\0\13\0\22\0\3\0\13\0\22\0\2\0\14\0\15\0\1\0"+
    "\3\0\1\0\2\0\14\0\64\0\40\0\3\0\1\0\3\0\2\0"+
    "\1\0\2\0\12\0\41\0\4\0\1\0\12\0\6\0\131\0\7\0"+
    "\5\0\2\0\42\0\1\0\1\0\5\0\106\0\12\0\37\0\1\0"+
    "\14\0\4\0\14\0\12\0\12\0\36\0\2\0\5\0\13\0\54\0"+
    "\4\0\32\0\6\0\12\0\46\0\27\0\5\0\4\0\65\0\12\0"+
    "\1\0\35\0\2\0\13\0\6\0\12\0\15\0\1\0\10\0\16\0"+
    "\1\0\2\0\77\0\5\0\57\0\21\0\7\0\4\0\12\0\21\0"+
    "\11\0\14\0\3\0\36\0\15\0\2\0\12\0\54\0\16\0\14\0"+
    "\44\0\24\0\10\0\12\0\3\0\3\0\12\0\44\0\2\0\11\0"+
    "\7\0\53\0\2\0\3\0\20\0\3\0\1\0\25\0\4\0\1\0"+
    "\6\0\1\0\2\0\3\0\1\0\5\0\300\0\72\0\1\0\5\0"+
    "\u0116\0\2\0\6\0\2\0\46\0\2\0\6\0\2\0\10\0\1\0"+
    "\1\0\1\0\1\0\1\0\1\0\1\0\37\0\2\0\65\0\1\0"+
    "\7\0\1\0\1\0\3\0\3\0\1\0\7\0\3\0\4\0\2\0"+
    "\6\0\4\0\15\0\5\0\3\0\1\0\7\0\16\0\5\0\32\0"+
    "\5\0\20\0\2\0\23\0\1\0\13\0\5\0\1\0\12\0\1\0"+
    "\1\0\15\0\1\0\20\0\15\0\3\0\40\0\20\0\15\0\4\0"+
    "\1\0\3\0\14\0\21\0\1\0\4\0\1\0\2\0\12\0\1\0"+
    "\1\0\3\0\5\0\6\0\1\0\1\0\1\0\1\0\1\0\1\0"+
    "\4\0\1\0\13\0\2\0\4\0\5\0\5\0\4\0\1\0\21\0"+
    "\51\0\u0a77\0\57\0\1\0\57\0\1\0\205\0\6\0\4\0\3\0"+
    "\2\0\14\0\46\0\1\0\1\0\5\0\1\0\2\0\70\0\7\0"+
    "\1\0\17\0\1\0\27\0\11\0\7\0\1\0\7\0\1\0\7\0"+
    "\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0"+
    "\1\0\40\0\57\0\1\0\u01d5\0\3\0\31\0\11\0\6\0\1\0"+
    "\5\0\2\0\5\0\4\0\126\0\2\0\2\0\2\0\3\0\1\0"+
    "\132\0\1\0\4\0\5\0\53\0\1\0\136\0\21\0\40\0\60\0"+
    "\20\0\u0200\0\u19c0\0\100\0\u51fd\0\3\0\u048d\0\103\0\56\0\2\0"+
    "\u010d\0\3\0\20\0\12\0\2\0\24\0\57\0\1\0\4\0\12\0"+
    "\1\0\37\0\2\0\120\0\2\0\45\0\11\0\2\0\147\0\2\0"+
    "\65\0\2\0\11\0\52\0\15\0\1\0\3\0\1\0\4\0\1\0"+
    "\27\0\5\0\4\0\1\0\13\0\1\0\7\0\64\0\14\0\2\0"+
    "\62\0\22\0\12\0\12\0\6\0\22\0\6\0\3\0\1\0\1\0"+
    "\2\0\13\0\34\0\10\0\2\0\27\0\15\0\14\0\35\0\3\0"+
    "\4\0\57\0\16\0\16\0\1\0\12\0\6\0\5\0\1\0\12\0"+
    "\12\0\5\0\1\0\51\0\16\0\11\0\3\0\1\0\10\0\2\0"+
    "\2\0\12\0\6\0\27\0\3\0\1\0\3\0\62\0\1\0\1\0"+
    "\3\0\2\0\2\0\5\0\2\0\1\0\1\0\1\0\30\0\3\0"+
    "\2\0\13\0\5\0\2\0\3\0\2\0\12\0\6\0\2\0\6\0"+
    "\2\0\6\0\11\0\7\0\1\0\7\0\1\0\53\0\1\0\16\0"+
    "\6\0\163\0\10\0\1\0\2\0\2\0\12\0\6\0\u2ba4\0\14\0"+
    "\27\0\4\0\61\0\u2104\0\u016e\0\2\0\152\0\46\0\7\0\14\0"+
    "\5\0\5\0\1\0\1\0\12\0\1\0\15\0\1\0\5\0\1\0"+
    "\1\0\1\0\2\0\1\0\2\0\1\0\154\0\41\0\u016b\0\22\0"+
    "\100\0\2\0\66\0\50\0\15\0\3\0\20\0\20\0\20\0\3\0"+
    "\2\0\30\0\3\0\31\0\1\0\6\0\5\0\1\0\207\0\2\0"+
    "\1\0\4\0\1\0\13\0\12\0\7\0\32\0\4\0\1\0\1\0"+
    "\32\0\13\0\131\0\3\0\6\0\2\0\6\0\2\0\6\0\2\0"+
    "\3\0\3\0\2\0\3\0\2\0\22\0\3\0\4\0";

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = yy_unpack_cmap(yycmap_packed);

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    32,    64,    32,    96,   128,   160,   192,    32,   160, 
      224,    32,   256,   288,   320,    32,    32,    32,   352,   384, 
      416,   448,   160,   480,   512,   128,   544,   256,   576,   608, 
      640,   672,   704,   736,   384,   768,   800,   832,   864,   832, 
      896,   928,   960,   992,  1024,  1056,   864,  1088,  1120,  1152, 
     1184,  1216,  1248,  1280,  1312,  1344,  1376,  1408,  1280,  1440, 
     1472,   160,  1504,    32,  1536,  1568,  1600,   160,   448,  1632, 
       32
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\2\1\10"+
    "\1\7\1\6\1\7\1\11\1\12\1\13\1\14\1\15"+
    "\1\6\1\2\2\7\1\6\1\7\1\2\2\6\1\16"+
    "\1\17\1\16\1\20\1\21\1\22\42\0\1\4\41\0"+
    "\1\23\2\24\1\0\1\23\1\25\2\26\1\0\1\27"+
    "\3\0\1\27\1\0\4\27\1\30\2\27\3\23\6\0"+
    "\1\31\2\27\1\32\1\0\3\27\1\32\1\0\1\33"+
    "\3\0\1\27\1\34\1\32\2\27\1\32\1\30\5\27"+
    "\7\0\3\27\1\0\4\27\1\0\1\27\3\0\1\27"+
    "\1\0\4\27\1\30\5\27\7\0\1\35\2\27\1\0"+
    "\1\35\1\25\2\26\1\0\1\27\3\0\1\27\1\0"+
    "\4\27\1\30\2\27\3\35\21\0\1\36\1\37\23\0"+
    "\1\31\2\0\1\34\4\0\1\34\1\0\1\40\4\0"+
    "\2\34\2\0\1\34\15\0\1\23\2\27\1\0\1\23"+
    "\1\25\2\26\1\0\1\27\3\0\1\27\1\0\4\27"+
    "\1\30\2\27\3\23\7\0\1\23\2\27\1\0\1\35"+
    "\1\25\2\26\1\0\1\27\3\0\1\27\1\0\4\27"+
    "\1\30\2\27\2\35\1\23\7\0\1\41\2\27\1\0"+
    "\1\41\1\25\2\26\1\0\1\27\1\42\2\0\1\27"+
    "\1\0\4\27\1\30\2\27\3\41\7\0\1\43\2\27"+
    "\1\44\1\43\1\27\2\43\1\0\1\27\3\0\1\43"+
    "\1\0\1\43\3\27\1\30\1\43\1\27\3\43\7\0"+
    "\1\45\2\27\1\0\1\45\3\27\1\0\1\27\3\0"+
    "\1\27\1\0\4\27\1\30\2\27\3\45\7\0\1\46"+
    "\2\27\1\0\1\46\3\27\1\47\1\50\3\0\1\27"+
    "\1\0\4\27\1\30\2\27\3\46\7\0\3\51\1\0"+
    "\1\51\1\0\2\51\1\0\1\51\3\0\1\51\1\0"+
    "\4\51\1\0\5\51\10\0\1\52\4\0\1\52\5\0"+
    "\2\52\3\0\1\52\2\0\2\52\12\0\1\27\1\32"+
    "\1\27\1\0\2\27\1\32\1\27\1\0\1\27\2\0"+
    "\1\34\1\32\1\0\2\27\1\32\1\27\1\30\2\32"+
    "\3\27\7\0\1\41\2\27\1\0\1\41\1\25\2\26"+
    "\1\0\1\27\3\0\1\27\1\0\4\27\1\30\2\27"+
    "\3\41\3\0\1\36\1\3\1\4\35\36\17\37\1\53"+
    "\20\37\5\0\1\34\4\0\1\34\5\0\2\34\3\0"+
    "\1\34\2\0\2\34\12\0\1\54\2\27\1\0\1\54"+
    "\1\25\2\26\1\0\1\27\3\0\1\27\1\0\4\27"+
    "\1\30\2\27\3\54\7\0\1\55\27\0\1\56\7\0"+
    "\1\44\2\0\2\44\1\0\2\44\5\0\1\44\1\0"+
    "\1\44\4\0\1\44\1\0\3\44\7\0\1\45\2\27"+
    "\1\0\1\45\1\27\2\26\1\0\1\27\3\0\1\27"+
    "\1\0\4\27\1\30\2\27\3\45\7\0\1\46\2\27"+
    "\1\0\1\46\3\27\1\0\1\27\3\0\1\27\1\0"+
    "\4\27\1\30\2\27\3\46\7\0\1\57\3\0\1\57"+
    "\21\0\3\57\7\0\3\51\1\0\1\51\1\60\2\51"+
    "\1\0\1\51\3\0\1\51\1\0\4\51\1\0\5\51"+
    "\6\0\1\31\2\0\1\52\4\0\1\52\1\0\1\31"+
    "\4\0\2\52\2\0\1\52\11\0\16\37\1\4\1\53"+
    "\20\37\3\0\1\61\1\62\1\63\1\27\1\0\1\62"+
    "\1\25\2\26\1\0\1\64\3\0\1\27\1\0\4\27"+
    "\1\30\2\63\3\62\7\0\1\65\3\0\1\65\21\0"+
    "\3\65\7\0\1\65\25\0\1\65\1\0\1\65\7\0"+
    "\2\51\1\66\1\0\1\51\1\0\1\51\1\66\1\0"+
    "\1\51\3\0\1\51\1\0\1\66\2\51\1\66\1\0"+
    "\5\51\10\0\1\67\22\0\2\67\12\0\1\70\2\27"+
    "\1\0\1\70\1\25\2\26\1\0\1\27\3\0\1\27"+
    "\1\0\4\27\1\30\2\27\3\70\7\0\1\27\1\71"+
    "\1\27\1\0\4\27\1\0\1\27\3\0\1\27\1\0"+
    "\4\27\1\30\2\71\3\27\7\0\1\27\1\63\1\27"+
    "\1\0\4\27\1\0\1\27\3\0\1\27\1\0\4\27"+
    "\1\30\2\63\3\27\21\0\1\72\25\0\2\51\1\73"+
    "\1\0\1\51\1\60\1\51\1\73\1\0\1\51\3\0"+
    "\1\51\1\0\1\73\2\51\1\73\1\0\5\51\10\0"+
    "\1\74\22\0\2\74\12\0\1\75\2\27\1\0\1\75"+
    "\1\25\2\26\1\0\1\27\3\0\1\27\1\0\4\27"+
    "\1\30\2\27\3\75\7\0\1\27\1\76\1\27\1\0"+
    "\4\27\1\0\1\27\3\0\1\27\1\0\4\27\1\30"+
    "\2\76\3\27\7\0\1\77\3\0\1\77\21\0\3\77"+
    "\10\0\1\100\22\0\2\100\12\0\1\101\2\27\1\0"+
    "\1\101\1\25\2\26\1\0\1\27\3\0\1\27\1\0"+
    "\4\27\1\30\2\27\3\101\7\0\1\102\3\0\1\102"+
    "\21\0\3\102\7\0\1\103\2\104\1\0\1\103\1\25"+
    "\2\105\1\0\1\27\3\0\1\104\1\0\1\104\1\27"+
    "\2\104\1\30\2\104\3\103\7\0\1\106\3\0\1\106"+
    "\21\0\3\106\7\0\1\103\2\27\1\0\1\103\1\25"+
    "\2\26\1\0\1\27\3\0\1\27\1\0\4\27\1\30"+
    "\2\27\3\103\7\0\1\107\3\0\1\107\21\0\3\107"+
    "\3\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack();


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  9,  1,  9,  1,  1,  1,  1,  9,  1,  1,  9,  1,  1,  1,  9, 
     9,  9,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0, 
     1,  0,  1,  1,  1,  1,  0,  0,  0,  1,  0,  1,  0,  0,  1,  0, 
     0,  1,  0,  0,  0,  0,  0,  1,  0,  0,  1,  0,  1,  1,  0,  9, 
     1,  0,  1,  1,  1,  0,  9
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /* user code: */
	public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
    public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[1664];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] yy_unpack_cmap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2296) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  final public void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  final public char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public Yytoken yylex() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      yychar+= yy_markedPos_l-yy_startRead;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_r = false;
          yycolumn++;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 70: 
          { return new Symbol(SimbolosTerminales.FECHA, 		yytext()); }
        case 72: break;
        case 58: 
          { return new Symbol(SimbolosTerminales.EMAIL, 		yytext()); }
        case 73: break;
        case 34: 
        case 35: 
          { return new Symbol(SimbolosTerminales.NUMBER, 		Long.decode(yytext()).doubleValue()); 	 }
        case 74: break;
        case 8: 
          {  return new Symbol(SimbolosTerminales.PLUS, 	yytext()); 	 }
        case 75: break;
        case 15: 
          {  return new Symbol(SimbolosTerminales.SEMI, 	yytext());	 }
        case 76: break;
        case 2: 
        case 3: 
          {                                }
        case 77: break;
        case 4: 
        case 7: 
        case 13: 
        case 14: 
        case 18: 
        case 28: 
        case 32: 
        case 36: 
        case 37: 
        case 43: 
        case 46: 
        case 49: 
        case 55: 
        case 60: 
        case 64: 
        case 66: 
          {  return new Symbol(SimbolosTerminales.NUMBER, 		Double.parseDouble(yytext()));			 }
        case 78: break;
        case 61: 
        case 63: 
          { return new Symbol(SimbolosTerminales.MATRICULA, 	yytext()); }
        case 79: break;
        case 67: 
        case 68: 
          { return new Symbol(SimbolosTerminales.DNI,			yytext()); }
        case 80: break;
        case 41: 
          { return new Symbol(SimbolosTerminales.NAME, 		yytext()); }
        case 81: break;
        case 17: 
          {  return new Symbol(SimbolosTerminales.RPAREN, 	yytext());	 }
        case 82: break;
        case 16: 
          {  return new Symbol(SimbolosTerminales.LPAREN, 	yytext()); 	 }
        case 83: break;
        case 9: 
          {  return new Symbol(SimbolosTerminales.MINUS, 	yytext()); 	 }
        case 84: break;
        case 10: 
          {  return new Symbol(SimbolosTerminales.DIVIDED, yytext());	 }
        case 85: break;
        case 11: 
          {  return new Symbol(SimbolosTerminales.TIMES, 	yytext()); 	 }
        case 86: break;
        case 1: 
        case 5: 
        case 6: 
        case 12: 
          { System.err.println("warning: Unrecognized character '"+ yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar);  }
        case 87: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
              { 	System.out.println("\nLeidas: "+yyline + " lineas, " + yychar + " caracteres");
    return new Symbol(EOF);
 }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
