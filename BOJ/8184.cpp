#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, a, b;
vector<int> v[200005];
int dist[200005];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    for (int i = 1; i <= n; i++) {
        if (dist[i]) continue;

        queue<int> q;
        int cnt = 0;
        dist[i] = 1;
        q.push(i);

        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            cnt++;
            for (int next : v[cur]) {
                if (dist[next]) 
                    continue;
                dist[next] = (dist[cur] & 1 ? 2 : 1);
                q.push(next);
            }
        }
        if (cnt == 1) {
            puts("NIE");
            return 0;
        }
    }

    puts("TAK");
    for (int i = 1; i <= n; i++) {
        if (dist[i] % 2 == 0) puts("K");
        else puts("S");
    }
}
