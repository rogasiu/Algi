#include <iostream>

using namespace std;

int liczSilniaIt(int silnia) {
    int wynik=1;
    for (int i=2;i<=silnia;i++) {
        wynik=wynik*i;
    }
    return wynik;
}

int liczSilniaRek(int silnia) {
    if(silnia==0){
        return 1;
    }
    return silnia * liczSilniaRek(silnia-1);
}

int main()
{
    int silnia;
    cout<<"Podaj liczbe calkowita, z ktorej obliczona zostanie silnia: ";
    cin>>silnia;
    int wynik;
    cout<<"Obliczanie iteracyjne"<<endl;
    wynik=liczSilniaIt(silnia);
    cout<<wynik<<endl;
    cout<<"Obliczanie rekurencyjne"<<endl;
    cout<<liczSilniaRek(silnia);
    return 0;
}
