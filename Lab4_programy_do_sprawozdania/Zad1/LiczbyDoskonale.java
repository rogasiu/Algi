package lDoskonale;

public class LiczbyDoskonale {

	public static void main(String[] args) {
		int tab[]=new int[19]; //utworzenie tablicy do przechowania wartości
		Licz licz=new Licz(); //stworzenie obiektu klasy Licz
		licz.Tablica(tab); //Wykorzystanie metody Tablica w celu zapełnienia tablicy
		licz.Doskonale(tab); //wykorzystanie metody Doskonale w celu wyszukania liczby doskonałej
	}

}
