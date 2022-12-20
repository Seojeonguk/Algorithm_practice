#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string str;
int t, i, j;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> t;
    while (t--) {
        cin >> str >> i >> j;
        str = str.erase(i, j - i);
        cout << str << '\n';
    }
}