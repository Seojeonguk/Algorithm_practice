#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
string a;
regex p("(100+1+|01)+");

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> t;

    while (t--) {
        cin >> a;
        cout << (regex_match(a, p) ? "YES\n" : "NO\n");
    }
} 
