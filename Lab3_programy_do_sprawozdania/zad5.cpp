#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main()
{
    srand(time(NULL));
    int x=(rand()%15)+1, y, i=1; //zadeklarowanie liczby losowej z przedzialu <1,15> oraz zmiennej iteracyjnej
    //cout<<x<<endl;
    cout<<"Proba "<<i<<endl;
    cout<<"Podaj liczbe z przedzialu <1,15> by odgadnac wynik: ";
    cin>>y;
    while(y!=x){ //petla while, ktora sie skonczy dopiero jezli uzytkownik odgadnie liczbe
        if(y<x) { //sprawdzenie czy liczba wpisana jest mnniejsza od liczby zgadywanej
            cout<<"Podania liczba jest mniejsza od wyniku."<<endl;
        } else {
            if(y>x) { //sprawdzenie czy liczba wpisana jest wieksza od liczby zgadywanej
                cout<<"Podania liczba jest wieksza od wyniku."<<endl;
            }
        }
        i++; //zliczenie kolejnej proby
        cout<<"Proba "<<i<<endl;
        cout<<"Podaj ponownie liczbe: ";
        cin>>y;
    }
    cout<<"Udalo ci sie odgadnac wynik!"<<endl;
    return 0;
}
