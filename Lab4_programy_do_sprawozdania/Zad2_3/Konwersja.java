
public class Konwersja {
	public static String naBin(int l) {
		String wynik= "";
		do {
			if (l%2==1) { 
				wynik='1'+wynik; 
			} else {
				wynik='0'+wynik; 
			}
			l/=2; 
		} while(l!=0); 
		return wynik;
	}
	
	public static String naHex(int l) {
		String wynik= "";
		do {
			if (l%16>=0 && l%16<=9) { 
				wynik=l%16+wynik;
			} else {
				if(l%16==10) { 
					wynik='A'+wynik;
				} else {
					if(l%16==11) {
						wynik='B'+wynik;
					} else {
						if(l%16==12) {
							wynik='C'+wynik;
						} else {
							if(l%16==13) {
								wynik='D'+wynik;
							} else {
								if(l%16==14) {
									wynik='E'+wynik;
								} else {
									if(l%16==15) {
										wynik='F'+wynik;
									}
								} 
							}   
						} 
					} 
				} 
			} 
			l/=16;
		} while(l!=0); 
		return wynik;
	}
	
	public static int binDec(String bin) {
		int wynik=0, j=0;
		for (int i=bin.length()-1;i>=0;i--, j++) {
			if (bin.charAt(i)=='0') {
				continue;
			} else {
				wynik+=Math.pow(2, j);
			}
		}
		return wynik;
	}  
	
	public static int hexDec(String hex) {
		int wynik=Integer.parseInt(hex,16);
		return wynik;
	}
}
