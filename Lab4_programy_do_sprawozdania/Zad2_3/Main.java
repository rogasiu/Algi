import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner skaner=new Scanner(System.in);
		System.out.println("Podaj liczbê: ");
		int l=skaner.nextInt(); 
		System.out.println("Podana liczba w systemie binarnym to: "+Konwersja.naBin(l)); 
		System.out.println("Podana liczba w systemie szesnastkowym to: "+Konwersja.naHex(l));
		System.out.println("Podaj liczbê w systemie binarnym: ");
		String bin=skaner.next();
		System.out.println("Podana liczba w systemie dziesiêtnym to: "+Konwersja.binDec(bin)); 
		System.out.println("Podaj liczbê w systemie szesnastkowym: ");
		String hex=skaner.next();
		System.out.println("Podana liczba w systemie dziesiêtnym to: "+Konwersja.hexDec(hex)); 

	}

}
