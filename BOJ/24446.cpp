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
int order[100002];

void solve() {
    int cnt = 0;
    queue<int> q;
    order[r] = 0;
    q.push(r);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : g[now]) {
            if (order[next] != -1) continue;
            order[next] = order[now] + 1;
            q.push(next);
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(order, -1, sizeof order);
    scanf("%d %d %d", &n, &m, &r);

    while (m--) {
        scanf("%d %d", &u, &v);
        g[u].push_back(v);
        g[v].push_back(u);
    }

    solve();

    for (int i = 1; i <= n; i++)
        printf("%d\n", order[i]);
}
