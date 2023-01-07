#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int q, r, x;
string rules[52];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> q;
    cin.ignore();
    for (int i = 1; i <= q; i++) {
        getline(cin, rules[i]);
    }
    cin >> r;
    for (int i = 0; i < r; i++) {
        cin >> x;
        string rule = "No such rule";
        
        if (1 <= x && x <= q)
            rule = rules[x];

        cout << "Rule " << x << ": " << rule << "\n";
    }
}
