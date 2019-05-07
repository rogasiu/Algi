package szybkie;

import java.util.Random;
import java.util.Scanner;

public class sort {
	
	public static void sortSzybkie(int tab[], int lewy, int prawy) {
		 int j=lewy, i=prawy;
		 double srodek=tab[(lewy+prawy)/2];
		 int pom;
		 do {
		  while (tab[j]<srodek) j++;
		  while (tab[i]>srodek) i--;
		  if (j<=i) {
		   pom=tab[j];
		   tab[j]=tab[i];
		   tab[i]=pom;
		   j++;
		   i--;
		  }
		 }
		 while (j<=i);
		 if (lewy<i) {
			 sortSzybkie(tab,lewy,i);
		 }
		 if (prawy>j) {
			 sortSzybkie(tab,j,prawy);
		 }
	}
	
	public static void sortSel(int tab[], int n, int j) {
		int pom=0, min=101;
		for (int i=j;i<n;i++) {
			if (tab[i]<min) {
				min=tab[i];
				pom=i;
			}
		}
		tab[pom]=tab[j];
		tab[j]=min;
		if(j<n-1) {
			sortSel(tab, n, j+1);
		}
	}

	public static void main(String[] args) {
		Scanner skaner= new Scanner(System.in);
		System.out.println("Ile elementów chcesz posortowaæ?");
		int n=skaner.nextInt();
		int[] tab=new int[n];
		Random rand=new Random();
		for (int i=0;i<n;i++) {
			tab[i]=rand.nextInt(100);
		}
		for (int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
		sortSzybkie(tab, 0, n-1);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
		for (int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
		for (int i=0;i<n;i++) {
			tab[i]=rand.nextInt(100);
		}
		for (int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
		sortSel(tab, n, 0);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
		for (int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
	}

}
