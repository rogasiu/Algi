import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Onp {

	public static void main(String[] args) {
		Queue<String> wyrazenie = new LinkedList<>(); 
		Queue<String> ONP = new LinkedList<>(); 
		Stack stos = new Stack();
		Scanner skaner=new Scanner(System.in);
		
		System.out.println("Ile elemntów posiada wyra¿enie?");
		int n=skaner.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Podaj liczbê b¹dz znak \"*\", \"/\", \"-\", \"+\", \"(\" lub \")\"");
			wyrazenie.add(skaner.next());
		}
		
		while(!wyrazenie.isEmpty() || !stos.empty()) {
			if(!wyrazenie.isEmpty() && wyrazenie.peek().equals(")")) {
				wyrazenie.poll();
				while(!stos.peek().equals("(")) {
					ONP.add((String) stos.pop());
				}
				stos.pop();
			} else {
				if(!wyrazenie.isEmpty() && wyrazenie.peek().equals("(")) {
					stos.add(wyrazenie.poll());
				} else {
					if(!wyrazenie.isEmpty() && stos.empty() && (wyrazenie.peek().equals("*") || wyrazenie.peek().equals("/") || wyrazenie.peek().equals("-") || wyrazenie.peek().equals("+"))) {
						stos.add(wyrazenie.poll());
					} else {
						if(!wyrazenie.isEmpty() && !stos.empty() && (wyrazenie.peek().equals("*") || wyrazenie.peek().equals("/") || wyrazenie.peek().equals("-") || wyrazenie.peek().equals("+"))) {
							if(stos.peek().equals("+") || stos.peek().equals("-")) {
								stos.add(wyrazenie.poll());
							} else {
								if(!wyrazenie.isEmpty() && (stos.peek().equals("*") || stos.peek().equals("/")) && (wyrazenie.peek().equals("-") || wyrazenie.peek().equals("+"))) {
									ONP.add((String) stos.pop());
									stos.add(wyrazenie.poll());
								} else {
									stos.add(wyrazenie.poll());
								}
							} 
						} else {
							 if (!wyrazenie.isEmpty()) {
								 ONP.add(wyrazenie.poll());
							 } else {
								 ONP.add((String) stos.pop());
							 }
						}
					}
				}
			}
		}
	
		while(!ONP.isEmpty()) {
			System.out.println(ONP.poll());
		}

	}

}
