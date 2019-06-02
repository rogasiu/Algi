import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Tab {

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
	
	public static void zapis(int tab[], String plik, int n) {
		try {
			PrintWriter zapisz = new PrintWriter(plik);
			for (int i=0;i<n;i++) {
				zapisz.println(tab[i]);
			}
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
	
	public static void pes(int n) {
		File plik = new File("pes"+n+".txt");
		int[] tab=new int[n];
		losuj(tab, n);
		sortSelMal(tab, n, 0);
		zapis(tab, "pes"+n+".txt", n);
	}
	
	public static void rand(int n) {
		File plik = new File("rand"+n+".txt");
		int[] tab=new int[n];
		losuj(tab, n);
		zapis(tab, "rand"+n+".txt", n);
	}
	
	public static void opt(int n) {
		File plik = new File("opt"+n+".txt");
		int[] tab=new int[n];
		losuj(tab, n);
		sortSel(tab, n, 0);
		swap(tab, n);
		zapis(tab, "opt"+n+".txt", n);
	}
	
	public static void main(String[] args) {
		
		int n=10;
		pes(n);

		
		n=20;
		pes(n);
		
		
		n=30;
		pes(n);
		
		
		n=50;
		pes(n);
		
		
		n=75;
		pes(n);
		
		
		n=100;
		pes(n);
		
		
		n=200;
		pes(n);
		
		
		n=300;
		pes(n);
		
		
		n=400;
		pes(n);
		
		
		n=500;
		pes(n);
		
		
		n=10;
		rand(n);
		
		
		n=20;
		rand(n);
		
		
		n=30;
		rand(n);
		
		
		n=50;
		rand(n);
		
		
		n=75;
		rand(n);
		
		
		n=100;
		rand(n);
		
		
		n=200;
		rand(n);
		
		
		n=300;
		rand(n);
		
		
		n=400;
		rand(n);
		
		
		n=500;
		rand(n);
		
		
		n=10;
		opt(n);
		
		
		n=20;
		opt(n);
		
		
		n=30;
		opt(n);
		
		
		n=50;
		opt(n);
		
		
		n=75;
		opt(n);
		
		
		n=100;
		opt(n);
		
		
		n=200;
		opt(n);
		
		
		n=300;
		opt(n);
		
		
		n=400;
		opt(n);
		
		
		n=500;
		opt(n);
	}

}
