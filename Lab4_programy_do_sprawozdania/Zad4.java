package wazona;

import java.util.Scanner;

public class srednia {
	
	public static double srednia(int sk, int ss, int sp, int lk, double wk, int ls, double ws, int lp, double wp) {
		double sr=0;
		sr=(sk+ss+sp)/(lk*wk+ls*ws+lp*wp);
		return sr;
	}

	public static void main(String[] args) {
		Scanner skaner = new Scanner(System.in);
		System.out.println("Ile ma by� ocen z kartk�wek?");
		int lk=skaner.nextInt();
		int[] k= new int[lk];
		for (int i=0;i<lk;i++) {
			System.out.println("Podaj "+(i+1)+" ocen�:");
			k[i]=skaner.nextInt();
		}
		System.out.println("Ile ma by� ocen ze sprawdzian�w?");
		int ls=skaner.nextInt();
		int[] s= new int[ls];
		for (int i=0;i<ls;i++) {
			System.out.println("Podaj "+(i+1)+" ocen�:");
			s[i]=skaner.nextInt();
		}
		System.out.println("Ile ma by� ocen z prac klasowych?");
		int lp=skaner.nextInt();
		int[] p= new int[lp];
		for (int i=0;i<lp;i++) {
			System.out.println("Podaj "+(i+1)+" ocen�:");
			p[i]=skaner.nextInt();
		}
		System.out.println("Podaj wag� dla kartk�wek: ");
		double wk=skaner.nextDouble();
		System.out.println("Podaj wag� dla sprawdzian�w: ");
		double ws=skaner.nextDouble();
		System.out.println("Podaj wag� dla prac klasowych: ");
		double wp=skaner.nextDouble();
		int sk=0;
		for (int i=0;i<lk;i++) {
			sk+=(k[i]*wk);
		}
		int ss=0;
		for (int i=0;i<ls;i++) {
			ss+=(s[i]*ws);
		}
		int sp=0;
		for (int i=0;i<lp;i++) {
			sp+=(p[i]*wp);
		}
		double sr;
		sr=srednia(sk, ss, sp, lk, wk, ls, ws, lp, wp);
		System.out.println("�rednia wa�ona to: "+sr);
	}

}
