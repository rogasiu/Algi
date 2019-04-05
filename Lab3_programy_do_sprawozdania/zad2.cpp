#include <iostream>
#include <ctime>
#include <cstdlib>
#include <cmath>

using namespace std;

void mnozenie(int **tab1, int **tab2, int n) {
    cout<<"Wynik mnozenia macierzy: ";
    int tab3[n][n], pom; //zadeklarowanie macierzy, na ktorej beda wykonywane operacje oraz zmiennej pomocniczej do wykonania mnozenia
    for(int i=0;i<n;i++) {
        cout<<endl;
        for(int j=0;j<n;j++) {
            pom=0;
            for(int k=0;k<n;k++) { //k odpowiada tutaj za kazda kolejna kolumne w drugiej macierzy i kazdy kolejny wiersz w pierwszej
                pom+=tab1[i][k]*tab2[k][j]; //mnozymy kolejne wartosci w wierszu z pierwszej macierzy i kolejne wartosci kolumny z drugiej macierzy oraz ich wyniki do siebie dodajemy
            }
            tab3[i][j]=pom; //przypisujemy wynik zmiennej pomocniczej do kolejnego elementu macierzy
            cout<<tab3[i][j]<<" "; //wypisanie macierzy na ekran
        }
    }
    cout<<endl;
    cout<<endl;
    delete[] tab3;
}

void transpozycja(int **tab1, int **tab2, int n) {
    int tab3[n][n];
    cout<<"Transpozycja macierzy pierwszej: ";
    for(int i=0;i<n;i++) {
        cout<<endl;
        for(int j=0;j<n;j++) {
            tab3[i][j]=tab1[j][i];/*transpozycja polega na zamianie miejscami wierszy na miejsce kolumn, wiêc skoro pêtle ida od poczatku wiersza
                                    do jego konca przechodzac potem do kolejnego wiersza, to podczas tego przypisywania wystarczy zamienic miejscami
                                        i oraz j, ¿eby dla pierwszej macierzy odczytywa³o wartosci kolumna po kolumnie, a nie wiersz po wierszu */
            cout<<tab3[i][j]<<" "; //wypisanie macierzy na ekran
        }
    }
    cout<<endl;
    cout<<endl;
    delete[] tab3;
    cout<<"Transpozycja macierzy drugiej: ";
    for(int i=0;i<n;i++) {
        cout<<endl;
        for(int j=0;j<n;j++) {
            tab3[i][j]=tab2[j][i];
            cout<<tab3[i][j]<<" ";
        }
    }
    cout<<endl;
    cout<<endl;
    delete[] tab3;
}

int wyznacznik(int **tab1, int n) {
    int det=0;
    int **tab3=new int *[n];
    for(int i=0;i<n;i++) {
        tab3[i]=new int [n];
    }
    if (n == 2) { //jesli macierz ma 2 wiersze i 2 kolumny, to wystarczy pomnozyc wartosci przekatnych i oba wyniki od siebie odjac
        return ((tab1[0][0]*tab1[1][1])-(tab1[1][0]*tab1[0][1]));
    }
    else {
       for (int i=0;i<n;i++) {
            int l=0;
            for (int j=1;j<n;j++) {
                int m=0;
                for (int k=0;k<n;k++) {
                    if (j==i) {
                        continue;
                    }
                   tab3[l][m]=tab1[j][k];
                   m++;
                }
                l++;
            }
            return det+=tab1[0][i]*pow(-1,1+(i+1))*wyznacznik(tab3, n-1 );
       }
    }
}

int main()
{
    srand(time(NULL));
    int n;
    cout << "Jaka wielkosc maja miec macierze kwadratowe? ";
    cin>>n;
    cout<<"Pierwsza macierz: ";
    int **tab1=new int *[n];
    for(int i=0;i<n;i++) {
        tab1[i]=new int [n];    //zadeklarowanie pierwszej macierzy w formie tablicy dynamicznej
    }
    for(int i=0;i<n;i++) { //i odpowiada wierszom
        cout<<endl;
        for(int j=0;j<n;j++){ //j odpowiada kolumnom
            tab1[i][j]=(rand()%10)+ 1;    //zapelniene tablicy dwuwymiarowej liczbami z przedzialu (1,10)
            cout<<tab1[i][j]<<" "; //wypisanie macierzy na ekran
        }
    }
    cout<<endl;
    cout<<endl;
    cout<<"Druga macierz: ";
    int **tab2=new int *[n];
    for(int i=0;i<n;i++) {
        tab2[i]=new int [n];    //zadeklarowanie drugiej macierzy w formie tablicy dynamicznej
    }
    for(int i=0;i<n;i++) { //i odpowiada wierszom
        cout<<endl;
        for(int j=0;j<n;j++){ //j odpowiada kolumnom
            tab2[i][j]=(rand()%10)+1; //zapelniene tablicy dwuwymiarowej liczbami z przedzialu (1,10)
            cout<<tab2[i][j]<<" "; //wypisanie macierzy na ekran
        }
    }
    cout<<endl;
    cout<<endl;
    mnozenie(tab1, tab2, n); //wywolanie fukncji mnozacej macierze
    transpozycja(tab1, tab2, n); //wywolanie funkcji obliczajaca tanspozycje
    cout<<"Wyznacznik macierzy pierwszej to: "<<wyznacznik(tab1, n)<<endl; //wywolanie funkcji obliczajaca wyznacznik
    /*double det=0;
    delete[] tab3;
    tab3[n-1][n-1];
    int l;
    for(int i=0;i<n;i++) {
        cout<<endl;
        for(int j=0;j<n-1;j++) {
            cout<<endl;
            for(int k=0;k<n-1;k++) {
                if(i>0) {
                    l=0;
                    if(k>=i) {
                        tab3[j][k]=tab1[j+1][k+1];
                        cout<<tab3[j][k]<<" ";
                        continue;
                    }
                    tab3[j][k]=tab1[j+1][k];
                    cout<<tab3[j][k]<<" ";
                    l++;
                    continue;
                }
                tab3[j][k]=tab1[j+1][k+1];
                cout<<tab3[j][k]<<" ";
            }
        }
        det+=tab1[1][i]*pow(-1,1+(i+1));
    }*/
    return 0;
}
