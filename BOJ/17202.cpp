#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

vector<int> p, n;
string a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> a >> b;
    for (int i = 0; i < 8; i++) {
        p.push_back(a[i] - '0');
        p.push_back(b[i] - '0');
    }

    while (p.size() != 2) {
        n.clear();
        for (int i = 0; i < p.size()-1; i++) {
            int nextValue = p[i] + p[i + 1];
            n.push_back(nextValue % 10);
        }
        p = n;
    }
    int ans = p[0] * 10 + p[1];
    printf("%02d\n", ans);
}
