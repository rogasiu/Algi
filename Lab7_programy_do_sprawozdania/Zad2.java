import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Pom {
	
	public static void sortSelMal(int tab[], int n, int j) {
		int pom=0, max=-1;
		for (int i=j;i<n;i++) {
			if (tab[i]>max) {
				max=tab[i];
				pom=i;
			}
		}
		tab[pom]=tab[j];
		tab[j]=max;
		if(j<n-1) {
			sortSelMal(tab, n, j+1);
		}
	}
	
	public static void sortSel(int tab[], int n, int j) {
		int pom=0, min=1001;
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
	
	public static void wstaw(int tab[], int n) {
		int pom, j;
		for(int i=1; i<n; i++ ) {
	        pom=tab[i];
	        for(j=i-1; j>=0 && tab[j]>pom; j--) {
	             tab[j+1]=tab[j];
	        }
	        tab[j+1]=pom;
	    }
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
	}
	
	public static void zapis(long tab[], String plik, int n, long sr) {
		try {
			PrintWriter zapisz = new PrintWriter(plik);
			for (int i=0;i<n;i++) {
				zapisz.println(tab[i]);
			}
			zapisz.println("xxx");
			zapisz.println(sr+" ns");
			zapisz.close();
		} catch (FileNotFoundException e) {
			System.out.println("B³¹d pliku");
		}
	}
	
	public static void losuj(int tab[], int n) {
		Random rand=new Random();
		for (int i=0;i<n;i++) {
			tab[i]=rand.nextInt(1000);
		}
	}
	
	public static void swap(int tab[], int n) {
		Random rand=new Random();
		int x=rand.nextInt(n), y=rand.nextInt(n);
		int pom=tab[x];
		tab[x]=tab[y];
		tab[y]=pom;
	}
	
	public static long srednia(long tab[], int n) {
		long suma=0;
		for (int i=0;i<n;i++) {
			suma+=tab[i];
		}
		suma/=n;
		return suma;
	}
	
	public static void pesWyb(int n) {
		File plik = new File("pes"+n+"Wyb.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSel(tab, n, 0);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru pesymistycznego "+n+" za pomoc¹ sortowania przez wybór");
			losuj(tab, n);
			sortSelMal(tab, n, 0);
			long czasRozpoczecia = System.nanoTime();
			sortSel(tab, n, 0);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "pes"+n+"Wyb.txt", 5, srednia(sr, 5));
	}
	
	public static void randWyb(int n) {
		File plik = new File("rand"+n+"Wyb.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSel(tab, n, 0);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru losowego "+n+" za pomoc¹ sortowania przez wybór");
			losuj(tab, n);
			long czasRozpoczecia = System.nanoTime();
			sortSel(tab, n, 0);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns"); 
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "rand"+n+"Wyb.txt", 5, srednia(sr, 5));
	}
	
	public static void optWyb(int n) {
		File plik = new File("opt"+n+"Wyb.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSel(tab, n, 0);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru optymistycznego "+n+" za pomoc¹ sortowania przez wybór");
			losuj(tab, n);
			sortSel(tab, n, 0);
			swap(tab, n);
			long czasRozpoczecia = System.nanoTime();
			sortSel(tab, n, 0);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns"); 
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "opt"+n+"Wyb.txt", 5, srednia(sr, 5));
	}
	
	public static void pesSzy(int n) {
		File plik = new File("pes"+n+"Szy.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSzybkie(tab, 0, n-1);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru pesymistycznego "+n+" za pomoc¹ sortowania szybkiego");
			losuj(tab, n);
			sortSelMal(tab, n, 0);
			long czasRozpoczecia = System.nanoTime();
			sortSzybkie(tab, 0, n-1);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns"); 
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "pes"+n+"Szy.txt", 5, srednia(sr, 5));
	}
	
	
	public static void randSzy(int n) {
		File plik = new File("rand"+n+"Szy.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSzybkie(tab, 0, n-1);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru losowego "+n+" za pomoc¹ sortowania szybkiego");
			losuj(tab, n);
			long czasRozpoczecia = System.nanoTime();
			sortSzybkie(tab, 0, n-1);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns"); 
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "rand"+n+"Szy.txt", 5, srednia(sr, 5));
	}
	
	public static void optSzy(int n) {
		File plik = new File("opt"+n+"Szy.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		sortSzybkie(tab, 0, n-1);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru optymistycznego "+n+" za pomoc¹ sortowania szybkiego");
			losuj(tab, n);
			sortSel(tab, n, 0);
			swap(tab, n);
			long czasRozpoczecia = System.nanoTime();
			sortSzybkie(tab, 0, n-1);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns"); 
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "opt"+n+"Szy.txt", 5, srednia(sr, 5));
	}
	
	public static void pesWst(int n) {
		File plik = new File("pes"+n+"Wst.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		wstaw(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru pesymistycznego "+n+" za pomoc¹ sortowania przez wstawianie");
			losuj(tab, n);
			sortSelMal(tab, n, 0);
			long czasRozpoczecia = System.nanoTime();
			wstaw(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "pes"+n+"Wst.txt", 5, srednia(sr, 5));
	}
	
	public static void randWst(int n) {
		File plik = new File("rand"+n+"Wst.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		wstaw(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru losowego "+n+" za pomoc¹ sortowania przez wstawianie");
			losuj(tab, n);
			long czasRozpoczecia = System.nanoTime();
			wstaw(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "rand"+n+"Wst.txt", 5, srednia(sr, 5));
	}
	
	public static void optWst(int n) {
		File plik = new File("opt"+n+"Wst.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		wstaw(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru optymistycznego "+n+" za pomoc¹ sortowania przez wstawianie");
			losuj(tab, n);
			sortSel(tab, n, 0);
			swap(tab, n);
			long czasRozpoczecia = System.nanoTime();
			wstaw(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "opt"+n+"Wst.txt", 5, srednia(sr, 5));
	}
	
	public static void pesBab(int n) {
		File plik = new File("pes"+n+"Bab.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		babel(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru pesymistycznego "+n+" za pomoc¹ sortowania b¹belkowego");
			losuj(tab, n);
			sortSelMal(tab, n, 0);
			long czasRozpoczecia = System.nanoTime();
			babel(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "pes"+n+"Bab.txt", 5, srednia(sr, 5));
	}
	
	public static void randBab(int n) {
		File plik = new File("rand"+n+"Bab.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		babel(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru losowego "+n+" za pomoc¹ sortowania b¹belkowego");
			losuj(tab, n);
			long czasRozpoczecia = System.nanoTime();
			babel(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "rand"+n+"Bab.txt", 5, srednia(sr, 5));
	}

	
	public static void optBab(int n) {
		File plik = new File("opt"+n+"Bab.txt");
		int[] tab=new int[n];
		long[] sr=new long[5];
		babel(tab, n);
		for(int i=1;i<=5;i++) {	
			System.out.println("Pomiar "+i+" dla zbioru optymistycznego "+n+" za pomoc¹ sortowania b¹belkowego");
			losuj(tab, n);
			sortSel(tab, n, 0);
			swap(tab, n);
			long czasRozpoczecia = System.nanoTime();
			babel(tab, n);
			long czasZakonczenia = System.nanoTime();
			long czasTrwania = czasZakonczenia - czasRozpoczecia;
			System.out.println("Czas: " + czasTrwania +" ns");
			sr[i-1]=czasTrwania;
		}
		System.out.println("Œrednia= "+srednia(sr, 5)+" ns");
		zapis(sr, "opt"+n+"Bab.txt", 5, srednia(sr, 5));
	}

	public static void main(String[] args) {
		int n=10;
		pesWyb(n);
		
		n=20;
		pesWyb(n);
		
		n=30;
		pesWyb(n);
		
		
		n=50;
		pesWyb(n);
		
		
		n=75;
		pesWyb(n);
		
		
		n=100;
		pesWyb(n);
		
		
		n=200;
		pesWyb(n);
		
		
		n=300;
		pesWyb(n);
		
		n=400;
		pesWyb(n);
		
		n=500;
		pesWyb(n);
		
		
		n=10;
		randWyb(n);
		
		
		n=20;
		randWyb(n);
		
		
		n=30;
		randWyb(n);
		
		
		n=50;
		randWyb(n);
		
		
		n=75;
		randWyb(n);
		
		
		n=100;
		randWyb(n);
		
		
		n=200;
		randWyb(n);
		
		
		n=300;
		randWyb(n);
		
		
		n=400;
		randWyb(n);
		
		
		n=500;
		randWyb(n);
		
		
		n=10;
		optWyb(n);
		
		
		n=20;
		optWyb(n);
		
		
		n=30;
		optWyb(n);
		
		
		n=50;
		optWyb(n);
		
		
		n=75;
		optWyb(n);
		
		
		n=100;
		optWyb(n);
		
		
		n=200;
		optWyb(n);
		
		
		n=300;
		optWyb(n);
		
		
		n=400;
		optWyb(n);
		
		
		n=500;
		optWyb(n);
		
		
		n=10;
		pesSzy(n);
		
		
		n=20;
		pesSzy(n);
		
		
		n=30;
		pesSzy(n);
		
		
		n=50;
		pesSzy(n);
		
		
		n=75;
		pesSzy(n);
		
		
		n=100;
		pesSzy(n);
		
		
		n=200;
		pesSzy(n);
		
		
		n=300;
		pesSzy(n);
		
		
		n=400;
		pesSzy(n);
		
		
		n=500;
		pesSzy(n);
		
		
		n=10;
		randSzy(n);
		
		
		n=20;
		randSzy(n);
		
		
		n=30;
		randSzy(n);
		
		
		n=50;
		randSzy(n);
		
		
		n=75;
		randSzy(n);
		
		
		n=100;
		randSzy(n);
		
		
		n=200;
		randSzy(n);
		
		
		n=300;
		randSzy(n);
		
		
		n=400;
		randSzy(n);
		
		
		n=500;
		randSzy(n);
		
		
		n=10;
		optSzy(n);
		
		
		n=20;
		optSzy(n);
		
		
		n=30;
		optSzy(n);
		
		
		n=50;
		optSzy(n);
		
		
		n=75;
		optSzy(n);
		
		
		n=100;
		optSzy(n);
		
		
		n=200;
		optSzy(n);
		
		
		n=300;
		optSzy(n);
		
		
		n=400;
		optSzy(n);
		
		
		n=500;
		optSzy(n);
		
		
		n=10;
		pesWst(n);
		
		
		n=20;
		pesWst(n);
		
		
		n=30;
		pesWst(n);
		
		
		n=50;
		pesWst(n);
		
		
		n=75;
		pesWst(n);
		
		
		n=100;
		pesWst(n);
		
		
		n=200;
		pesWst(n);
		
		
		n=300;
		pesWst(n);
		
		
		n=400;
		pesWst(n);
		
		
		n=500;
		pesWst(n);
		
		
		n=10;
		randWst(n);
		
		
		n=20;
		randWst(n);
		
		
		n=30;
		randWst(n);
		
		
		n=50;
		randWst(n);
		
		n=75;
		randWst(n);
		
		
		n=100;
		randWst(n);
		
		
		n=200;
		randWst(n);
		
		
		n=300;
		randWst(n);
		
		
		n=400;
		randWst(n);
		
		
		n=500;
		randWst(n);
		
		
		n=10;
		optWst(n);
		
		
		n=20;
		optWst(n);
		
		
		n=30;
		optWst(n);
		
		
		n=50;
		optWst(n);
		
		
		n=75;
		optWst(n);
		
		
		n=100;
		optWst(n);
		
		
		n=200;
		optWst(n);
		
		
		n=300;
		optWst(n);
		
		n=400;
		optWst(n);
		
		
		n=500;
		optWst(n);
		
		
		n=10;
		pesBab(n);
		
		
		n=20;
		pesBab(n);
		
		
		n=30;
		pesBab(n);
		
		
		n=50;
		pesBab(n);
		
		
		n=75;
		pesBab(n);
		
		
		n=100;
		pesBab(n);
		
		
		n=200;
		pesBab(n);
		
		
		n=300;
		pesBab(n);
		
		
		n=400;
		pesBab(n);
		
		
		n=500;
		pesBab(n);
		
		
		n=10;
		randBab(n);
		
		
		n=20;
		randBab(n);
		
		
		n=30;
		randBab(n);
		
		
		n=50;
		randBab(n);
		
		
		n=75;
		randBab(n);
		
		
		n=100;
		randBab(n);
		
		
		n=200;
		randBab(n);
		
		
		n=300;
		randBab(n);
		
		
		n=400;
		randBab(n);
		
		
		n=500;
		randBab(n);
		
		
		n=10;
		optBab(n);
		
		
		n=20;
		optBab(n);
		
		
		n=30;
		optBab(n);
		
		
		n=50;
		optBab(n);
		
		
		n=75;
		optBab(n);
		
		
		n=100;
		optBab(n);
		
		
		n=200;
		optBab(n);
		
		
		n=300;
		optBab(n);
		
		
		n=400;
		optBab(n);
		
		
		n=500;
		optBab(n);
	}

}
