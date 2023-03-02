#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans = INT32_MAX, a, b;
vector<int> v[100002];
pair<int, int> p[100002];
bool visited[100002];

int solve(int st) {
    queue<int> q;
    pair<int, int> maxP, minP;
    maxP = minP = p[st];
    q.push(st);

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next : v[cur]) {
            if (visited[next]) continue;
            maxP.first = max(maxP.first, p[next].first);
            maxP.second = max(maxP.second, p[next].second);
            minP.first = min(minP.first, p[next].first);
            minP.second = min(minP.second, p[next].second);
            visited[next] = true;
            q.push(next);
        }
    }

    return 2 * abs(maxP.first - minP.first) + 2 * abs(maxP.second - minP.second);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);
    
    for (int i = 1; i <= n; i++)
        scanf("%d %d", &p[i].first, &p[i].second);

    while (m--) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        if (visited[i]) continue;
        ans = min(ans, solve(i));
    }

    printf("%d\n", ans);
}
