#include <iostream>

using namespace std;

int liczPotege(int podst, int wykl) {
    int wynik=podst;
    for(int i=2;i<=wykl;i++) {
        wynik=wynik*podst;
    }
    return wynik;
}

int main()
{
    int podst;
    cout<<"Podaj podstawe potegi: ";
    cin>>podst;
    int wykl;
    cout<<"Podaj wykladnik potegi: ";
    cin>>wykl;
    cout<<liczPotege(podst, wykl);
    return 0;
}
