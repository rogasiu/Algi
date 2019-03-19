// Zad_7_F_kwad_i_lin.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
#include <math.h>
using namespace std;
void fkwadr(double a, double b, double c);
double lin(double b, double c, double x);

int main()
{
	double a, b, c, x = 0;
	cout << "Program rozwiaze rownanie kwadratowe, dla wspolczynnikow b i c oraz rownanie kwadratowe dla wspolczynnikow a, b i c." << endl;
	cout << "Wprwoadz a" << endl;
	cin >> a;
	cout << "Wprwoadz b" << endl;
	cin >> b;
	cout << "Wprwoadz c" << endl;
	cin >> c;

	cout << "Funkcja liniowa to: y = " << b << "x + " << c << endl;
	cout << "W funkcji liniowej x = " << lin(b, c, x) << endl;
	
	fkwadr(a, b, c);
	cout << "-----------" << endl << endl;
}
double lin(double b, double c, double x) {
	x = 0;
	x = (-1 * c) / b;
	return x;
}

void fkwadr(double a, double b, double c)
{
	//delta = b^2 + 4ac
	double delta = b * b - 4 * a*c;
	cout << "Rownanie " << a << "*x^2" << " + " << b << "*x " << "+ " << c << endl;
	cout << "Delta " << delta << endl;
	if (delta > 0)
	{
		double pDel = sqrt(delta);
		double x1 = (-b + pDel) / 2 * a;
		double x2 = (-b - pDel) / 2 * a;
		cout << "x1=" << x1 << " i x2=" << x2 << endl;
	}
	else if (delta == 0)
	{
		double x = (-b) / 2 * a;
		cout << "x=" << x << endl;
	}
	else
	{
		cout << "Delta jest ujemna. Rownanie nie ma rozwiazań w dziedzinie rzeczywistej" << endl;
	}
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
