#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, q, a, b, x;
vector<int> v[65546];
int depths[65546];

void solve(int cur, int parent, int depth) {
    depths[depth]++;

    for (int next : v[cur]) {
        if (next == parent) continue;
        solve(next, cur, depth + 1);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d", &n, &q);
        for (int i = 1; i <= n; i++) {
            v[i].clear();
            depths[i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            scanf("%d %d", &a, &b);
            v[a].push_back(b);
            v[b].push_back(a);
        }

        solve(1, 0, 1);

        for (int i = 0; i < q; i++)
            scanf("%d", &x);
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (q < depths[i]) break;
            q -= depths[i];
            ans += depths[i];
        }

        printf("Case #%d: %d\n", tc, ans);
    }
}
