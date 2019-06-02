import java.util.Scanner;
import java.util.Stack;

public class Stos {

	public static void main(String[] args) {
		Stack stos = new Stack();
		
		stos.push(1);
		stos.push(40);
		stos.push(13);
		stos.push("Micha³");
		stos.push("Weronika");
		
		for (int i=1;i<=5;i++) {
			System.out.println(stos.pop());
		}
		
		
		Stack<String> stosONP = new Stack();
		Stack<String> ONP = new Stack();
		
		
		Scanner skaner=new Scanner(System.in);
		int n; 
		double a, b, x;
		System.out.println("Ile elementów posiada wyra¿enie ONP?");
		n=skaner.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Podaj liczbê b¹dz znak \"*\", \"/\", \"-\" lub \"+\"");
			ONP.add(skaner.next());
		}
		
		for(int i=0;i<n;i++) {
			stosONP.add(ONP.pop());
		}
		
		for(int i=0;i<n;i++) {
			if(stosONP.peek().equals("*")) {
				stosONP.pop();
				a=Double.parseDouble((String) ONP.pop());
				b=Double.parseDouble((String) ONP.pop());
				x=b*a;
				ONP.add(Double.toString(x));
			} else {
				if(stosONP.peek().equals("/")) {
					stosONP.pop();
					a=Double.parseDouble((String) ONP.pop());
					b=Double.parseDouble((String) ONP.pop());
					x=b/a;
					ONP.add(Double.toString(x));
					 
				} else {
					if(stosONP.peek().equals("-")) {
						stosONP.pop();
						a=Double.parseDouble((String) ONP.pop());
						b=Double.parseDouble((String) ONP.pop());
						x=b-a;
						ONP.add(Double.toString(x));
					} else {
						if(stosONP.peek().equals("+")) {
							stosONP.pop();
							a=Double.parseDouble((String) ONP.pop());
							b=Double.parseDouble((String) ONP.pop());
							x=b+a;
							ONP.add(Double.toString(x));
						} else {
							ONP.add(stosONP.pop());
						}
					}
				}
			}
		}
		System.out.println("Wynik: "+ONP.pop());
		
		
	}

}
