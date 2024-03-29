
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20141204 (SVN rev 60)
//----------------------------------------------------

package cup.example;

import java_cup.runtime.*;
import cup.example.Lexer;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20141204 (SVN rev 60) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\005\000\002\002\004\000\002\002" +
    "\004\000\002\002\005\000\002\002\004\000\002\003\005" +
    "\000\002\004\005\000\002\004\005\000\002\004\005\000" +
    "\002\004\005\000\002\004\003\000\002\005\005\000\002" +
    "\005\005\000\002\005\003\000\002\006\006\000\002\006" +
    "\006\000\002\006\006\000\002\006\006\000\002\006\010" +
    "\000\002\006\010\000\002\006\003\000\002\006\004\000" +
    "\002\006\006\000\002\007\003\000\002\007\003\000\002" +
    "\007\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\072\000\024\005\015\006\004\011\uffe8\013\017\014" +
    "\020\015\014\016\011\021\013\022\uffe8\001\002\000\006" +
    "\011\uffe9\022\uffe9\001\002\000\016\004\ufff4\005\ufff4\006" +
    "\ufff4\010\ufff4\012\ufff4\017\ufff4\001\002\000\016\004\ufff7" +
    "\005\ufff7\006\ufff7\010\032\012\ufff7\017\031\001\002\000" +
    "\010\004\074\005\025\006\026\001\002\000\006\011\061" +
    "\022\060\001\002\000\004\011\055\001\002\000\026\002" +
    "\051\005\015\006\004\011\uffe8\013\017\014\020\015\014" +
    "\016\011\021\013\022\uffe8\001\002\000\016\004\uffed\005" +
    "\uffed\006\uffed\010\uffed\017\uffed\020\046\001\002\000\004" +
    "\011\043\001\002\000\006\011\uffea\022\uffea\001\002\000" +
    "\004\004\042\001\002\000\004\011\037\001\002\000\004" +
    "\011\021\001\002\000\024\005\015\006\004\011\uffe8\013" +
    "\017\014\020\015\014\016\011\021\023\022\uffe8\001\002" +
    "\000\010\005\025\006\026\012\024\001\002\000\016\004" +
    "\uffed\005\uffed\006\uffed\010\uffed\012\uffed\017\uffed\001\002" +
    "\000\016\004\ufff2\005\ufff2\006\ufff2\010\ufff2\012\ufff2\017" +
    "\ufff2\001\002\000\024\005\036\006\004\011\uffe8\013\017" +
    "\014\020\015\014\016\011\021\023\022\uffe8\001\002\000" +
    "\024\005\015\006\027\011\uffe8\013\017\014\020\015\014" +
    "\016\011\021\023\022\uffe8\001\002\000\016\004\ufff9\005" +
    "\ufff9\006\ufff9\011\uffe9\012\ufff9\022\uffe9\001\002\000\016" +
    "\004\ufffa\005\ufffa\006\ufffa\010\032\012\ufffa\017\031\001" +
    "\002\000\024\005\015\006\004\011\uffe8\013\017\014\020" +
    "\015\014\016\011\021\023\022\uffe8\001\002\000\024\005" +
    "\015\006\004\011\uffe8\013\017\014\020\015\014\016\011" +
    "\021\023\022\uffe8\001\002\000\016\004\ufff6\005\ufff6\006" +
    "\ufff6\010\ufff6\012\ufff6\017\ufff6\001\002\000\016\004\ufff5" +
    "\005\ufff5\006\ufff5\010\ufff5\012\ufff5\017\ufff5\001\002\000" +
    "\016\004\ufffb\005\ufffb\006\ufffb\010\032\012\ufffb\017\031" +
    "\001\002\000\016\004\ufff8\005\ufff8\006\ufff8\011\uffea\012" +
    "\ufff8\022\uffea\001\002\000\024\005\015\006\004\011\uffe8" +
    "\013\017\014\020\015\014\016\011\021\023\022\uffe8\001" +
    "\002\000\010\005\025\006\026\012\041\001\002\000\016" +
    "\004\ufff3\005\ufff3\006\ufff3\010\ufff3\012\ufff3\017\ufff3\001" +
    "\002\000\026\002\ufffd\005\ufffd\006\ufffd\011\ufffd\013\ufffd" +
    "\014\ufffd\015\ufffd\016\ufffd\021\ufffd\022\ufffd\001\002\000" +
    "\024\005\015\006\004\011\uffe8\013\017\014\020\015\014" +
    "\016\011\021\023\022\uffe8\001\002\000\010\005\025\006" +
    "\026\012\045\001\002\000\016\004\ufff1\005\ufff1\006\ufff1" +
    "\010\ufff1\012\ufff1\017\ufff1\001\002\000\024\005\015\006" +
    "\004\011\uffe8\013\017\014\020\015\014\016\011\021\023" +
    "\022\uffe8\001\002\000\010\004\ufffc\005\025\006\026\001" +
    "\002\000\010\004\054\005\025\006\026\001\002\000\004" +
    "\002\000\001\002\000\004\004\053\001\002\000\026\002" +
    "\ufffe\005\ufffe\006\ufffe\011\ufffe\013\ufffe\014\ufffe\015\ufffe" +
    "\016\ufffe\021\ufffe\022\ufffe\001\002\000\026\002\001\005" +
    "\001\006\001\011\001\013\001\014\001\015\001\016\001" +
    "\021\001\022\001\001\002\000\024\005\015\006\004\011" +
    "\uffe8\013\017\014\020\015\014\016\011\021\023\022\uffe8" +
    "\001\002\000\010\005\025\006\026\012\057\001\002\000" +
    "\016\004\ufff0\005\ufff0\006\ufff0\010\ufff0\012\ufff0\017\ufff0" +
    "\001\002\000\016\004\uffec\005\uffec\006\uffec\010\uffec\012" +
    "\uffec\017\uffec\001\002\000\024\005\064\006\062\011\uffe8" +
    "\013\017\014\020\015\014\016\011\021\023\022\uffe8\001" +
    "\002\000\010\006\071\011\uffe9\022\uffe9\001\002\000\010" +
    "\005\025\006\026\012\070\001\002\000\010\005\065\011" +
    "\uffea\022\uffea\001\002\000\004\021\066\001\002\000\004" +
    "\012\067\001\002\000\016\004\uffee\005\uffee\006\uffee\010" +
    "\uffee\012\uffee\017\uffee\001\002\000\016\004\uffeb\005\uffeb" +
    "\006\uffeb\010\uffeb\012\uffeb\017\uffeb\001\002\000\004\021" +
    "\072\001\002\000\004\012\073\001\002\000\016\004\uffef" +
    "\005\uffef\006\uffef\010\uffef\012\uffef\017\uffef\001\002\000" +
    "\026\002\uffff\005\uffff\006\uffff\011\uffff\013\uffff\014\uffff" +
    "\015\uffff\016\uffff\021\uffff\022\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\072\000\016\002\011\003\015\004\006\005\005\006" +
    "\004\007\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\014\003\051\004\047\005\005\006\004" +
    "\007\007\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\004\021\005\005\006\004\007\007\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\005\034\006\004\007\007\001\001\000\010\005" +
    "\027\006\004\007\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\006\033\007\007\001\001\000\006\006" +
    "\032\007\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\004\037\005" +
    "\005\006\004\007\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\004\043\005\005\006" +
    "\004\007\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\012\004\046\005\005\006\004\007\007\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\004" +
    "\055\005\005\006\004\007\007\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\004\062\005" +
    "\005\006\004\007\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
//@@CUPDBG1

  ComplexSymbolFactory f = new ComplexSymbolFactory();
  symbolFactory = f;
  File file = new File("input.txt");
  FileInputStream fis = null;
  try {
    fis = new FileInputStream(file);
  } catch (IOException e) {
    e.printStackTrace();
  } 
  lexer = new Lexer(f,fis);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
//@@CUPDBG2
 return lexer.next_token(); 
    }

//@@CUPDBG0

  protected Lexer lexer;
	
	private double MEM[] = new double[100]; 
	private int position = 0;
	private boolean isDouble(Double number) {
		return number != null && number.intValue() != number;
  	}

	private String guardoResultadoMem (Integer position, Double result) {
		MEM[position] = result;			
		if (isDouble(result)) { return "Guardo MEM[" + position +"] = " + result; }
		else 			 	  { return "Guardo MEM[" + position +"] = " + result.intValue(); }
  	}

	

	private void result (Double number) {
		if (isDouble(number)) { System.out.println(number); }
		else 			 	  { System.out.println(number.intValue()); }
 	}
	
	private void setPosition(int i){
		position = i;
	}
	
	private int getPosition(){
		return position;
	}
	
	private void updateValuePosition(double value){
		MEM[getPosition()] = value;
	}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // expr_list ::= expr_list A SEMI 
            {
              Object RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG3
 System.out.print("RESULTADO: ");result(a1); 			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= expr_list EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr_list ::= A SEMI 
            {
              Object RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG4
 System.out.print("RESULTADO: "); result(a1); 							
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr_list ::= expr_list guardar SEMI 
            {
              Object RESULT =null;
		Location mem1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location mem1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object mem1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG5
 System.out.println(mem1);			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expr_list ::= guardar SEMI 
            {
              Object RESULT =null;
		Location mem1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location mem1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object mem1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG6
 System.out.println(mem1); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // guardar ::= MEM EQUALS A 
            {
              Object RESULT =null;
		Location memoriaxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location memoriaxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Integer memoria = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG7
 RESULT = guardoResultadoMem(memoria, a1);	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("guardar",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // A ::= A PLUS B 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location a2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG8
 RESULT = a1 + a2;	/*	System.out.println("Detecto la suma: " + a1 + "+" + a2 ); 	*/	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // A ::= A MINUS B 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location a2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG9
 RESULT = a1 - a2;	/*	System.out.println("Detecto la resta: " + a1 + "-" + a2 ); 	*/	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // A ::= A MINUS MINUS 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		//@@CUPDBG10
 RESULT = MEM[getPosition()];		updateValuePosition(MEM[getPosition()]-1.0); 			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // A ::= A PLUS PLUS 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		//@@CUPDBG11
 RESULT = MEM[getPosition()];		updateValuePosition(MEM[getPosition()]+1.0); 		
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // A ::= B 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG12
 RESULT = a1; 			/*System.out.println("Genero A: " + a1  );		*/				
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // B ::= B TIMES C 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location a2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG13
 RESULT = a1 * a2; 		/*System.out.println("Detecto la multi: " + a1 + "*" + a2 );*/		
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("B",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // B ::= B DIVIDED C 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location a2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a2 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG14
 RESULT = a1 / a2; 		/*System.out.println("Detecto la div: " + a1 + "/" + a2 );	*/	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("B",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // B ::= C 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG15
 RESULT = a1; 	 		/*System.out.println("Genero B: " + a1  );		*/				
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("B",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // C ::= EXP LPAREN A RPAREN 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG16
 RESULT = Math.exp(a1);	/*	System.out.println("Detecto el exp(" + a1 + ")" );	*/			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // C ::= LOG LPAREN A RPAREN 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG17
 RESULT = Math.log(a1);	/*System.out.println("Detecto el log(" + a1 + ")" );	*/			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // C ::= COS LPAREN A RPAREN 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG18
 RESULT = Math.cos(a1); 	/* 	System.out.println("Detecto el cos(" + a1 + ")" );	*/			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // C ::= SIN LPAREN A RPAREN 
            {
              Double RESULT =null;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG19
 RESULT = Math.sin(a1); 	/*  System.out.println("Detecto el sin(" + a1 + ")" );	*/			
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // C ::= sign LPAREN MINUS MINUS MEM RPAREN 
            {
              Double RESULT =null;
		Location signoxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xleft;
		Location signoxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xright;
		Integer signo = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		Location memoriaxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location memoriaxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Integer memoria = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG20
 RESULT = signo*(MEM[memoria] - 1);	guardoResultadoMem(memoria, MEM[memoria]-1);		/*System.out.println("Detecto predecremento: --" + MEM[memoria]  ); */		
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // C ::= sign LPAREN PLUS PLUS MEM RPAREN 
            {
              Double RESULT =null;
		Location signoxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xleft;
		Location signoxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xright;
		Integer signo = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		Location memoriaxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location memoriaxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Integer memoria = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG21
 RESULT = signo *(MEM[memoria] + 1);	guardoResultadoMem(memoria, MEM[memoria]+1);		/*System.out.println("Detecto preincremento: ++" + MEM[memoria]  ); 	*/	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // C ::= MEM 
            {
              Double RESULT =null;
		Location memoriaxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location memoriaxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Integer memoria = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG22
 RESULT = MEM[memoria];	setPosition(memoria);	/*System.out.println("Hola Cojo valor MEM[" + memoria +"] ="+ MEM[memoria]);*/	
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // C ::= sign NUMBER 
            {
              Double RESULT =null;
		Location signoxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location signoxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Integer signo = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location nxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location nxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Double n = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		//@@CUPDBG23
 RESULT = signo * n;  	/*System.out.println("Detecto el numero: " + n);	*/				
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // C ::= sign LPAREN A RPAREN 
            {
              Double RESULT =null;
		Location signoxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xleft;
		Location signoxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xright;
		Integer signo = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		Location a1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location a1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Double a1 = (Double)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		//@@CUPDBG24
 RESULT = signo * a1;  /*	System.out.println("Signo expresión: " + signo);*/		
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("C",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // sign ::= PLUS 
            {
              Integer RESULT =null;
		//@@CUPDBG25
 RESULT =  1; 			/*System.out.println("Detecto signo + " );	*/					
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("sign",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // sign ::= MINUS 
            {
              Integer RESULT =null;
		//@@CUPDBG26
 RESULT = -1; 			/*System.out.println("Detecto signo - " );	*/					
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("sign",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // sign ::= 
            {
              Integer RESULT =null;
		//@@CUPDBG27
 RESULT =  1; 			/*System.out.println("No detecto signo" );	*/					
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("sign",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
