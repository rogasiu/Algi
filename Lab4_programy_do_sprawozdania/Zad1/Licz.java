package lDoskonale;

public class Licz {
	public static void Tablica(int tab[]) {
		for (int i=2;i<=20;i++) {
			tab[i-2]=i; //wype�nienie elementu tablicy warto�ci� i
		}
	}
	
	public static void Doskonale(int tab[]) {
		for (int i=2;i<=20;i++) {
			int suma=0;
			for (int j=1;j<i;j++) {
				if (tab[i-2]%j==0) { //sprawdzenie czy element tablicy si� dzieli przez dan� liczb�
					suma+=j; //sumowanie wszystkich dzielnik�w danego elementu tablicy
				}
			}
			if (i==suma) { //sprawdzenie czy suma dzielnik�w r�wna si� warto�ci elementu tablici
				System.out.println("Liczba "+i+" JEST doskona�a");
			} else {
				System.out.println("Liczba "+i+" nie jest doskona�a");
			}
		}
	}
	
}
