import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Stru {

	public static void main(String[] args) {
		Scanner skaner = new Scanner(System.in);
		String x="";
		do {
			System.out.println("Jak� struktur� chcesz utworzy�? Dost�pne s�: stos, kolejka i wektor. Wybierz wpisuj�� \"s\", \"k\" lub \"w\"");
			x=skaner.next();
		} while(!x.equals("s") && !x.equals("k") && !x.equals("w"));
		
		String y;
		String z;
		if (x.equals("s")) {
			Stack stos = new Stack();
			do {
				System.out.println("Jak� operacj� chcesz wykona�? Dost�pne s�: \"dodaj\", \"usun\", \"pobierzskrajne\", \"pobierz\", \"sprawdz\", \"wielkosc\", \"czypusty\", \"koniec\"");
				y=skaner.next();
				if (y.equals("dodaj")) {
					System.out.println("Jaki element chcesz doda�?");
					z=skaner.next();
					stos.push(z);
				} else {
					if (y.equals("usun")) {
						System.out.println("Usuni�ty element: "+stos.pop());
					} else {
						if(y.equals("pobierzskrajne")) {
							System.out.println("Pierwszy element: "+stos.firstElement());
							System.out.println("Ostatni element: "+stos.lastElement());
						} else {
							if(y.equals("pobierz")) {
								System.out.println(stos.pop());
							} else {
								if(y.equals("sprawdz")) {
									System.out.println("Jakie wyra�enie chcesz sprawdzi�?");
									z=skaner.next();
									System.out.println(stos.contains(z));
								} else {
									if(y.equals("wielkosc")) {
										System.out.println("Wielko�� struktury: "+stos.size());
									} else {
										if(y.equals("czypusty")) {
											System.out.println(stos.empty());
										}
									}
								}
							}
						}
					}
				}
				
			} while (!y.equals("koniec"));
			
		}
		
		
		if (x.equals("k")) {
			Queue<String> kolejka = new ArrayDeque<>(); 
			do {
				System.out.println("Jak� operacj� chcesz wykona�? Dost�pne s�: \"dodaj\", \"usun\", \"pobierzskrajne\", \"pobierz\", \"sprawdz\", \"wielkosc\", \"czypusty\", \"koniec\"");
				y=skaner.next();
				if (y.equals("dodaj")) {
					System.out.println("Jaki element chcesz doda�?");
					z=skaner.next();
					kolejka.add(z);
				} else {
					if (y.equals("usun")) {
						System.out.println("Usuni�ty element: "+kolejka.remove()); 
					} else {
						if(y.equals("pobierzskrajne")) {
							System.out.println("Pierwszy element: "+((ArrayDeque<String>) kolejka).getFirst());
							System.out.println("Ostatni element: "+((ArrayDeque<String>) kolejka).getLast());
						} else {
							if(y.equals("pobierz")) {
								System.out.println(kolejka.poll());
							} else {
								if(y.equals("sprawdz")) {
									System.out.println("Jakie wyra�enie chcesz sprawdzi�?");
									z=skaner.next();
									System.out.println(kolejka.contains(z));
								} else {
									if(y.equals("wielkosc")) {
										System.out.println("Wielko�� struktury: "+kolejka.size());
									} else {
										if(y.equals("czypusty")) {
											System.out.println(kolejka.isEmpty());
										}
									}
								}
							}
						}
					}
				}
				
			} while (!y.equals("koniec"));
			
		}
		
		
		if (x.equals("w")) {
			Vector wektor = new Vector();
			do {
				System.out.println("Jak� operacj� chcesz wykona�? Dost�pne s�: \"dodaj\", \"usun\", \"pobierzskrajne\", \"pobierz\", \"sprawdz\", \"wielkosc\", \"czypusty\", \"koniec\"");
				y=skaner.next();
				if (y.equals("dodaj")) {
					System.out.println("Jaki element chcesz doda�?");
					z=skaner.next();
					wektor.addElement(z);
				} else {
					if (y.equals("usun")) {
						System.out.println("Element o jakim indeksie chcesz usun��?");
						z=skaner.next();
						System.out.println("Usuni�ty element: "+wektor.elementAt(Integer.parseInt(y)));
						wektor.removeElementAt(Integer.parseInt(y));
					} else {
						if(y.equals("pobierzskrajne")) {
							System.out.println("Pierwszy element: "+wektor.firstElement());
							System.out.println("Ostatni element: "+wektor.lastElement());
						} else {
							if(y.equals("pobierz")) {
								System.out.println("Element o jakim indeksie chcesz pobra�?");
								z=skaner.next();
								System.out.println(wektor.elementAt(Integer.parseInt(z)));
							} else {
								if(y.equals("sprawdz")) {
									System.out.println("Jakie wyra�enie chcesz sprawdzi�?");
									z=skaner.next();
									System.out.println(wektor.contains(z));
								} else {
									if(y.equals("wielkosc")) {
										System.out.println("Wielko�� struktury: "+wektor.size());
									} else {
										if(y.equals("czypusty")) {
											System.out.println(wektor.isEmpty());
										}
									}
								}
							}
						}
					}
				}
				
			} while (!y.equals("koniec"));
		}
		
		
	}

}
