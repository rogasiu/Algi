package lab8;

import java.util.Random;
import java.util.Scanner;

public class Alg {

	public static int algHoraea(int tab[], int m, int n, int k) {
		if (n==0 && k==0) {
			return tab[0];
		}
		int j=m, i=n;
		double r=tab[0];
		int pom;
		do {
		  while (tab[j]<r) j++;
		  while (tab[i]>r) i--;
		  if (j<=i) {
			  pom=tab[j];
			  tab[j]=tab[i];
			  tab[i]=pom;
			  j++;
			  i--;
		  }
		}
		while (j<=i);
		if (i<k) {
			return algHoraea(tab, 0, i, k);
		} else {
			return algHoraea(tab, i+1, n, k-1);
		}
	}	
	
	
	public static void main(String[] args) {
		Scanner skaner= new Scanner(System.in);
		System.out.println("Ile elementów ma mieæ tablica?");
		int n=skaner.nextInt();
		int[] tab=new int[n];
		Random rand=new Random();
		for (int i=0;i<n;i++) {
			tab[i]=rand.nextInt(100);
		}
		for (int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
		System.out.println("Który element ma byæ wyszukany?");
		int k=skaner.nextInt();
		System.out.println("Szukanym elementem jest liczba: "+algHoraea(tab, 0, n-1, k));
	}
}
