#include <iostream>

using namespace std;

bool pierwsza(int n) {
    for(int i=2;i<n;i++) {
        if (n%i==0) { //sprawdzamy czy liczba badana dzieli sie przez liczbe inna niz przez 1 i siebie sama
            return false;
        }
    }
    return true;
}

int main()
{
    unsigned int n;
    do {
        cout<<"Podaj liczbe naturalna wieksza od 1: "; //poniewaz liczbv pierwsze sa liczbami naturalnymi wiekszymi od 1, wiec bez sensu jest sprawdzanie czy liczba mniejsza od 1 jest liczba pierwsza
        cin>>n;
    } while(n<=1); //sprawdzenie czy uzytkownik rzeczywiscie posal liczbe wieksza od 1
    if(pierwsza(n)) {
        cout<<n<<" jest liczba pierwsza "<<endl;
    } else {
        cout<<n<<" nie jest liczba pierwsza "<<endl;
    }
    return 0;
}
