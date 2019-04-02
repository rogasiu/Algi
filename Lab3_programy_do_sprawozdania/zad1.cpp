#include <iostream>
#include <cmath>

using namespace std;

poleobwod(double a, double b, double c) { //funkcja obliczajaca pole i obwod trojkata
    double obw=a+b+c;
    double p=0.5*obw;
    double P=sqrt(p*(p-a)*(p-b)*(p-c)); //obliczanie pola trojkata ze wzoru Herona
    cout<<"Pole trojkata to: "<<P<<endl;
    cout<<"Obwod trojkata to: "<<obw<<endl;
}

int main()
{
    double a, b, c; //deklaracja zmiennych odpowiadającym bokom trojkata
    cout<<"Podaj pierwszy bok trojkata: ";
    cin>>a;
    cout<<"Podaj drugi bok trojkata: ";
    cin>>b;
    cout<<"Podaj trzeci bok trojkata: ";
    cin>>c;
    if(a+b>c && a+c>b && c+b>a) {  //sprawdzenie czy z danych bokow utworzymy trojkat
        poleobwod(a, b, c); //wywolanie funkcji liczacej pole i obwod trojkata
    } else {
        cout<<"Z tych bokow nie da sie stworzyc trojkata"<<endl;
    }
    return 0;
}
