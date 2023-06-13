#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans;
set<string> s;
string a;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a;
        if (a == "ENTER") {
            s.clear();
            continue;
        }
        if (s.find(a) == s.end()) {
            ans++;
            s.insert(a);
        }
    }
    cout << ans;
}