#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string str;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> str;
    set<string> s;
    for (int i = 0; i < str.size(); i++) {
        for (int j = 1; j <= str.size()-i; j++) {
            string nextstr = str.substr(i, j);
            s.insert(nextstr);
        }
    }
    cout << s.size() << endl;
}