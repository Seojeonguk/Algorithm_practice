#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int cnt[] = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

string a, b;
vector<int> p, n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> a >> b;

    for (int i = 0; i < a.size(); i++) {
        p.push_back(cnt[a[i] - 'A']);
        p.push_back(cnt[b[i] - 'A']);
    }

    while (p.size() != 2) {
        n.clear();
        for (int i = 0; i < p.size() - 1; i++) {
            int nextValue = p[i] + p[i + 1];
            n.push_back(nextValue % 10);
        }
        p = n;
    }

    int ans = p[0] * 10 + p[1];
    printf("%02d\n", ans);
}
