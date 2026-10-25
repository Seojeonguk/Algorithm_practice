#include<iostream>
using namespace std;
 
int main() {
    int tc, a, b;
    cin >> tc;
    
    while(tc-- > 0) {
        cin >> a >> b;
        int c = a % b;
        cout << (b - c) % b << endl;
    }
}