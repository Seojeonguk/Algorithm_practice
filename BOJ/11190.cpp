#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, a, b;
vector<int> v[10002];
int types[10001];

int solve(int st) {
    int cnt = 0;
    queue<int> q;
    q.push(st);
    types[st] = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        cnt++;

        for (int next : v[cur]) {
            if (types[next]) continue;
            types[next] = (types[cur] == 1 ? 2 : 1);
            q.push(next);
        }
    }

    return cnt;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);
    while (m--) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        if (types[i]) continue;
        if (solve(i) == 1) {
            puts("Impossible");
            return 0;
        }
    }

    for (int i = 1; i <= n; i++)
        printf("%s ", types[i] == 1 ? "pub" : "house");
}
