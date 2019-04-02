#include <iostream>

using namespace std;

int main()
{
    double a1, a2, b1, b2, y1, y2, wx, wy, w;
    cout<<"Podaj a1: ";
    cin>>a1;
    cout<<"Podaj b1: ";
    cin>>b1;
    cout<<"Podaj y1: ";
    cin>>y1;
    cout<<"Podaj a2: ";
    cin>>a2;
    cout<<"Podaj b2: ";
    cin>>b2;
    cout<<"Podaj y2: ";
    cin>>y2;
    if (a1==0 && b1==0 && a2==0 && b2==0) {
        cout<<"Wzory sa nieprawdziwe"<<endl;
        return 0;
    }
    w=a1*b2-b1*a2;
    wx=y1*b2-b1*y2;
    wy=a1*y2-y1*a2;
    if (w!=0) {
        cout<<"x="<<wx/w<<endl;
        cout<<"y="<<wy/w<<endl;
        cout<<"Uklad jest oznaczony"<<endl;
    } else {
        if(wx==0 && wy==0) {
            cout<<"Uklad jest nieoznaczony"<<endl;
        } else {
            cout<<"Uklad jest sprzeczny"<<endl;
        }
    }
    return 0;
}
