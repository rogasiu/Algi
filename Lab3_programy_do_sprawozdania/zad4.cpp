#include <iostream>

using namespace std;

void suma(double x, double y) {
    cout<<"Wynik dodawania to: "<<x+y<<endl; //liczenie sumy
}

void roznica(double x, double y) {
    cout<<"Wynik odejmowania to: "<<x-y<<endl; //liczenie roznicy
}

void iloczyn(double x, double y) {
    cout<<"Wynik mnozenia to: "<<x*y<<endl; //liczenie iloczynu
}

void iloraz(double x, double y) {
    if(y==0) { //if zabezpieczajacy program przed liczeniem przez zero
        cout<<"Nie mozna dzielic przez 0"<<endl;
    } else {
        cout<<"Wynik dzielenia to: "<<x/y<<endl; //liczenie ilorazu
    }
}

int main()
{
    double x, y; //deklaracja dwoch zmiennych do obliczenia
    cout << "Wprowadz dwie liczby: " << endl;
    cin>>x;
    cin>>y;
    suma(x, y); //wywolanie funkcji liczacej sume
    roznica(x, y); //wywolanie funkcji liczacej roznice
    iloczyn(x, y); //wywolanie funkcji liczacej iloczyn
    iloraz(x, y); //wywolanie funkcji liczacej iloraz
    return 0;
}
