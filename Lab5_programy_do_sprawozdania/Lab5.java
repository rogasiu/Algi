package sortowanie;

import java.util.Random;
import java.util.Scanner;

public class Sort {
	
	public static void wstaw(int tab[], int n) {
		int pom, j;
		for(int i=1; i<n; i++ ) {
	        pom=tab[i];
	        for(j=i-1; j>=0 && tab[j]>pom; j--) {
	             tab[j+1]=tab[j];
	        }
	        tab[j+1]=pom;
	    }
		for(int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
		System.out.println("xxxxxxxxxxxx");
	}
	
	public static void babel(int tab[], int n) {
		int pom;
		for (int i=0;i<n;i++) {
			for (int j=1;j<n;j++) {
				pom=tab[j];
				if(tab[j-1]>tab[j]) {
					tab[j]=tab[j-1];
					tab[j-1]=pom;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(tab[i]);
		}
	}

	public static void main(String[] args) {
		Random rand=new Random();
		Scanner skaner=new Scanner(System.in);
		System.out.println("Ile elementów ma byæ posortowanych?");
		int n=skaner.nextInt();
		int[] tab=new int[n];
		for(int i=0;i<n;i++) {
			tab[i]=rand.nextInt(100);
		}
		wstaw(tab, n);
		for(int i=0;i<n;i++) {
			tab[i]=rand.nextInt(100);
		}
		babel(tab, n);
	}

}
