import java.util.Scanner;
import java.util.Stack;

public class Ha {

	public static void hanoi (int n, Stack A, Stack B, Stack C) {
	    if (n>0) {
	    	hanoi (n-1, A, C, B);
	    	System.out.println("Stan: "+A+" "+B+" "+C);
	    	int x=(int) A.pop();
	        B.push(x);
	        System.out.println("Z "+A.firstElement()+" na "+B.firstElement());
	        hanoi (n-1, C, B, A);
	    }
	}
	
	
	public static void main(String[] args) {
		Scanner skaner = new Scanner(System.in);
		int n;
	    
		System.out.println("Ile masz krazkow?");
	    n=skaner.nextInt();
	 
	    Stack A = new Stack();
	    Stack B = new Stack();
	    Stack C = new Stack();
	    
	    A.add("A");
	    B.add("B");
	    C.add("C");
	   
	    for (int i=1;i<=n;i++) {
	    	A.push(i);
	    }
	    hanoi(n, A, B, C);
	}

}
