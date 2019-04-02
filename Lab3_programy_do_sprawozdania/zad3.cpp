#include <iostream>

using namespace std;

void fib(int n) {
    long long f1=0, f2=1; //zadeklarowanie i przypisanie wartosci pierwszemu i drugiemu wyrazowi ciagu, ktore beda potem reprezentowac poprzedni i nastepny wyraz ciagu
    cout<<"Wyraz 1 to: 0"<<endl;
    for (int i=1;i<n;i++) {
        cout<<"Wyraz "<<i+1<<" to: "<<f2<<endl;
        f2+=f1; //sumujemy dwa poprzednie wyrazy do otrzymania kolejnego wyrazu
        f1=f2-f1; //poniewaz dwa poprzednie wyrazy zostaly zsumowane do otrzymania kolejnego wyrazu, to odwrocenie tej operacji da nam poprzedni wyraz wymagany do następnych operacji
    }
}

int main()
{
    int n; //deklaracja zmiennej wyrazow ciagu, ktore maja zostac wypisane
    cout<<"Jaka liczbe wyrazow ciagu Fibonacciego wypisac? ";
    cin>>n;
    fib(n);
    return 0;
}
