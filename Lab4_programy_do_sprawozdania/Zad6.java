package cezar;

import java.util.Scanner;

public class szyfr {
	
	public static String zakoduj(String slowo) {
		String szyfr="";
		int ascii;
		for (int i=0;i<slowo.length();i++) {
			ascii=slowo.charAt(i);
			if (ascii==120) {
				ascii=97;
			} else {
				if(ascii==121) {
					ascii=98;
				} else {
					if(ascii==122) {
						ascii=99;
					} else {
						if (ascii==88) {
							ascii=65;
						} else {
							if (ascii==89) {
								ascii=66;
							} else {
								if(ascii==90) {
									ascii=67;
								} else {
									ascii+=3;
								}
							}
						}
					}
				}
			} 
			szyfr+=Character.toString((char) ascii);
		}
		return szyfr;
	}
	
	public static String dekoduj(String szyfr) {
		String slowo="";
		int ascii;
		for (int i=0;i<szyfr.length();i++) {
			ascii=szyfr.charAt(i);
			if (ascii==97) {
				ascii=120;
			} else {
				if(ascii==98) {
					ascii=121;
				} else {
					if(ascii==99) {
						ascii=122;
					} else {
						if (ascii==65) {
							ascii=88;
						} else {
							if (ascii==66) {
								ascii=89;
							} else {
								if(ascii==67) {
									ascii=90;
								} else {
									ascii-=3;
								}
							}
						}
					}
				}
			} 
			slowo+=Character.toString((char) ascii);
		}
		return slowo;
	}

	public static void main(String[] args) {
		Scanner skaner = new Scanner(System.in);
		System.out.println("Wprowadz s³owo, które chcesz zakodowaæ: ");
		String slowo=skaner.nextLine();
		String szyfr=zakoduj(slowo);
		System.out.println("Zakodowane s³owo: "+szyfr);
		System.out.println("Wprowadz s³owo, które chcesz dekodowaæ: ");
		slowo=skaner.nextLine();
		slowo=dekoduj(szyfr);
		System.out.println("Dekodowane s³owo: "+slowo);
	}
}
