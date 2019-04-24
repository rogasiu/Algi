import java.util.Scanner;

public class palindrom {
	
	public static boolean czyPalindrom(String p) {
		for (int i=0; i<=p.length()/2; i++) {
			if(p.charAt(i)!=p.charAt(p.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner skaner= new Scanner(System.in);
		System.out.println("Podaj wyraz");
		String p=skaner.nextLine();
		if (czyPalindrom(p))System.out.println("Wyraz jest palindormem");
		else System.out.println("Wyraz nie jest palindromem");

	}

}
