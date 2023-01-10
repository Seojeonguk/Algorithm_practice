#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, r, u, v;
vector<int> g[100002];
int order[100002], depths[100002];

void solve() {
    int cnt = 0;
    queue<int> q;
    depths[r] = 0;
    order[r] = ++cnt;
    q.push(r);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : g[now]) {
            if (depths[next] != -1) continue;
            depths[next] = depths[now] + 1;
            order[next] = ++cnt;
            q.push(next);
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(depths, -1, sizeof depths);
    scanf("%d %d %d", &n, &m, &r);

    while (m--) {
        scanf("%d %d", &u, &v);
        g[u].push_back(v);
        g[v].push_back(u);
    }

    solve();

    ll ans = 0;
    for (int i = 1; i <= n; i++)
        ans += 1LL * depths[i] * order[i];

    printf("%lld\n", ans);
}
