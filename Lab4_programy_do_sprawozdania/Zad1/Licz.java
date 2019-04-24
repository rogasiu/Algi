package lDoskonale;

public class Licz {
	public static void Tablica(int tab[]) {
		for (int i=2;i<=20;i++) {
			tab[i-2]=i; //wype³nienie elementu tablicy wartoœci¹ i
		}
	}
	
	public static void Doskonale(int tab[]) {
		for (int i=2;i<=20;i++) {
			int suma=0;
			for (int j=1;j<i;j++) {
				if (tab[i-2]%j==0) { //sprawdzenie czy element tablicy siê dzieli przez dan¹ liczbê
					suma+=j; //sumowanie wszystkich dzielników danego elementu tablicy
				}
			}
			if (i==suma) { //sprawdzenie czy suma dzielników równa siê wartoœci elementu tablici
				System.out.println("Liczba "+i+" JEST doskona³a");
			} else {
				System.out.println("Liczba "+i+" nie jest doskona³a");
			}
		}
	}
	
}
