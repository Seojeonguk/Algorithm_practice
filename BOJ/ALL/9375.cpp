#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        map<string, int> m;
        string a, b;
        for (int i = 0; i < n; i++) {
            cin >> a >> b;
            m[b] += 1;
        }
        
        int ans = 1;
        for (auto i : m) ans *= (i.second+1);
        printf("%d\n", ans - 1);
    }
}