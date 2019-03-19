// Zad_2_NWD_NWW.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
using namespace std;
int nww(int, int);
int nwd(int, int);

int main()
{
	setlocale(LC_ALL, "");
	cout << "Program oblicza Największy wspólby dzielnik (NWD) oraz Najmniejsza wspólna wielokrotność (NWW)" << endl;
	cout << "Podaj większą z liczb: " << endl;
	int a, b;
	cin >> a;
	cout << "Podaj mniejszą z liczb: " << endl;
	cin >> b;
	int najw = nwd(a, b);
	int najm = nww(a, b);
	cout << "Największy wspólny dzielnik to: " << najw << endl << "Najmniejsza wspólna wielokrotność: " << najm << endl;
	return 0;

}

int nww(int a, int b) {
	int wynik;
	wynik = (a*b) / nwd(a, b);
	return wynik;
	
}

int nwd(int a, int b) {
	// z algorytmu Euklidesa z użyciem modulo
	int pom;
	while (b != 0) {
		pom = b;
		b = a % b;
		a = pom;
	}
	return a;

}

// Uruchomienie programu: Ctrl + F5 lub menu Debugowanie > Uruchom bez debugowania
// Debugowanie programu: F5 lub menu Debugowanie > Rozpocznij debugowanie

// Porady dotyczące rozpoczynania pracy:
//   1. Użyj okna Eksploratora rozwiązań, aby dodać pliki i zarządzać nimi
//   2. Użyj okna programu Team Explorer, aby nawiązać połączenie z kontrolą źródła
//   3. Użyj okna Dane wyjściowe, aby sprawdzić dane wyjściowe kompilacji i inne komunikaty
//   4. Użyj okna Lista błędów, aby zobaczyć błędy
//   5. Wybierz pozycję Projekt > Dodaj nowy element, aby utworzyć nowe pliki kodu, lub wybierz pozycję Projekt > Dodaj istniejący element, aby dodać istniejące pliku kodu do projektu
//   6. Aby w przyszłości ponownie otworzyć ten projekt, przejdź do pozycji Plik > Otwórz > Projekt i wybierz plik sln
