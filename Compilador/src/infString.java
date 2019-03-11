import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class infString {
	
	public static String listAStr(Queue<String>a){
		String b="";
		while(!a.isEmpty()){
			b=b+a.poll()+" ";
		}
		return b;
	}

	public static Queue <String>infixToPosfix(String a){
		Queue<String>b=new LinkedList<String>();
		Stack<String>c=new Stack<String>();
		Queue<String>m=new LinkedList<String>();
		m.addAll(Arrays.asList(a.split(" ")));
		String operators="+*-/";
		while(!m.isEmpty()){
			c.add(m.poll());
			try{
				b.add(String.valueOf(Integer.parseInt(c.peek())));
			}catch(Exception e){
				
			}
			if(c.peek().equals(")")){
				while(!c.peek().equals("(")){
					if(operators.contains(c.peek())){
						b.add(c.pop());
					}else{
						c.pop();
					}
				}
				c.pop();
			}
		}
		return b;
		
	}
	
	public static Queue<String> infijoPostfijo(String a){
		String expr =depurar(a);
		    String[] arrayInfix = expr.split(" ");
		    Stack < String > E = new Stack < String > (); //Pila entrada
		    Stack < String > P = new Stack < String > (); //Pila temporal para operadores
		    Stack < String > S = new Stack < String > (); //Pila salida
		    for (int i = arrayInfix.length - 1; i >= 0; i--) {
		        E.push(arrayInfix[i]);
		    }
		    while (!E.isEmpty()) {
		        switch (pref(E.peek())){
		          case 1:
		            P.push(E.pop());
		            break;
		          case 3:
		          case 4:
		            while(pref(P.peek()) >= pref(E.peek())) {
		              S.push(P.pop());
		            }
		            P.push(E.pop());
		            break; 
		          case 2:
		            while(!P.peek().equals("(")) {
		              S.push(P.pop());
		            }
		            P.pop();
		            E.pop();
		            break; 
		          case 5:
		          E.pop();
		          String aux= "-"+E.pop();
		          S.push(aux);
		          break;
		          default:
		            S.push(E.pop()); 
		        } 
		      } 

		      //Eliminacion de `impurezas´ en la expresiones algebraicas
		      String infix = expr.replace(" ", "");
		      String postfix = S.toString().replaceAll("[\\]\\[,]", "");
		      return StrAQueue(postfix);
		}
		private static String depurar(String s) {
		    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
		    if(s.charAt(0)=='-'){
		    	s="0"+s;
		    }
		    s = "(" + s + ")";
		    String simbols = "+-*/()";
		    String str = "";
		    String numeros="0123456789()";
		  
		    //Deja espacios entre operadores
		    for (int i = 0; i < s.length(); i++) {
		      if (simbols.contains("" + s.charAt(i))) {
		    if(i>1 && (numeros.contains("" + s.charAt(i-1))==false||s.charAt(i-1)=='(') && s.charAt(i)=='-'){
		    str += " ^ ";
		    }else if(str.length()-2>0&&simbols.contains(String.valueOf(str.charAt(str.length()-2)))){
		    	str += s.charAt(i)+" ";
		    }else{
		    	str += " " + s.charAt(i) + " ";
		    }
		      }else str += s.charAt(i);
		    }
		    return str.replaceAll("\\s+", " ").trim();
		  } 

		  //Jerarquia de los operadores
		  private static int pref(String op) {
		    int prf = 99;
		    if (op.equals("^")) prf = 5;
		    if (op.equals("*") || op.equals("/")) prf = 4;
		    if (op.equals("+") || op.equals("-")) prf = 3;
		    if (op.equals(")")) prf = 2;
		    if (op.equals("(")) prf = 1;
		    return prf;
		  }

	
	
	public static Queue<String> StrAQueue(String s){
		Queue<String> b=new LinkedList<String>();
		String a[]=s.split(" ");
		for(int i=0;i<a.length;i++){
			b.add(a[i]);
			
		}
		return b;
		
		
	}
	public static Queue<String> StrArr(String s){
		LinkedList<String> b=new LinkedList<String>();
		String a[]=s.split(" ");
		for(int i=0;i<a.length;i++){
			b.add(a[i]);
			
		}
		return b;
		
		
	}
	
	

}
