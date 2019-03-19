#include <iostream>
#include <cmath>

using namespace std;

void minMax(int tab[], int dl) {
    int min, max;
    min=tab[0];
    max=tab[0];
    for (int i=0; i<dl; i++) {
        if(tab[i]>max) {
            max=tab[i];
        } else {
            if(tab[i]<min) {
                min=tab[i];
            }
        }
    }
    cout<<"Wartosc minimalna tablicy to "<<min<<endl;
    cout<<"Wartosc maksymanlna tablicy to "<<max<<endl;
}

void rozrzut(int tab[]) {
    cout<<"Miedzy jakimi elementami chcesz poznac rozrzut wartosci? Elementy w tablicy liczymy od 0"<<endl;
    int x, y, wynik=0;
    cin>>x;
    cin>>y;
    if(x>y) {
        for(int i=y+1;i<x;i++) {
            wynik+=tab[i];
        }
        cout<<"Rozrzut wartosci to "<<wynik<<endl;
    } else {
        if(y>x) {
            for(int i=x+1;i<y;i++) {
                wynik+=tab[i];
            }
            cout<<"Rozrzut wartosci to "<<wynik<<endl;
        } else {
            cout<<"Rozrzut wartosci to "<<wynik<<endl;
        }
    }
}

double srednia(int tab[], int dl) {
    int suma=0;
    double sr;
    for(int i=0;i<dl;i++) {
        suma+=tab[i];
    }
    cout<<"Suma wszystkich elementow tablicy to "<<suma<<endl;
    sr=suma/dl;
    cout<<"Srednia arytmetyczna elementow to "<<sr<<endl;
    return sr;
}

void odchylenie(int tab[], int dl, double sr) {
    double suma=0, odch;

    for (int i=0;i<dl;i++) {
        suma+=(tab[i]-sr)*(tab[i]-sr);
    }
    cout<<"Wariancja elementow tablic to "<<suma/dl<<endl;
    odch=sqrt(suma/dl);
    /*for (double j=0.000001;j<=suma/dl;j+=0.000001) {
        if(j*j==suma/dl) {
            odch=j;
            break;
        }
    }*/
    cout<<"Odchylenie standardowe to "<<odch<<endl;
}

void podzielnosc(int tab[], int dl) {
    int licz=0;
    for (int i=0;i<dl;i++) {
        if (tab[i]%3==0) {
            licz++;
        }
    }
    cout<<"Liczba elementow podzielnych przez 3 to "<<licz<<endl;
}

void element(int tab[]) {
    int elem;
    cout<<"Ktory element tablicy chcesz wyswietlic?"<<endl;
    cin>>elem;
    cout<<elem<<" element tablicy to "<<tab[elem]<<endl;
}

int main()
{
    cout << "Ile elementow ma byc w tablicy? ";
    int dl;
    cin>>dl;
    int tab[dl];
    cout<<"Wprowadz elementy: "<<endl;
    for (int i=0;i<dl;i++) {
        cin>>tab[i];
    }
    minMax(tab, dl);
    rozrzut(tab);
    double sr;
    sr=srednia(tab, dl);
    odchylenie(tab, dl, sr);
    podzielnosc(tab, dl);
    element(tab);
    return 0;
}
