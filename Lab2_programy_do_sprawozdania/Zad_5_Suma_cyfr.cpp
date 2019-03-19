// Zad_5_Suma_cyfr.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
using namespace std;
int scyfr(int);

int main()
{
	cout << "Program zliczy sume cyfr liczby." << endl << "Podaj liczbe wieksza od 1000: " << endl;
	int liczba;
	cin >> liczba;
	cout << "Suma cyfr " << liczba << " wynosi: " << scyfr(liczba) << endl;


}

int scyfr(int liczba) {
	int suma = 0;
	while (liczba > 0) {
		suma = suma + liczba % 10; //dzięki modulo mamy ostanią cyfrę z liczby
		liczba = liczba / 10;
	}
	return suma;

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
