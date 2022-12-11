#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long solve();
long long m, n, start;
pair<long long, long long> p[11];
queue<pair<long long, int> > q;
bool visit[1000002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld %lld", &m, &n, &start);
    for (int i = 0; i < n; i++) {
        scanf("%lld %lld", &p[i].first, &p[i].second);
    }

    printf("%lld\n", solve());
}

long long solve() {
    q.push({ start,0 });
    visit[start] = true;

    while (!q.empty()) {
        auto now = q.front();
        q.pop();

        if (now.first == 0) {
            return now.second;
        }

        for (int i = 0; i < n; i++) {
            long long next = (((now.first % m) * (p[i].first % m) % m) + (p[i].second % m)) % m;
            if (visit[next]) {
                continue;
            }
            visit[next] = true;
            q.push({ next,now.second + 1 });
        }
    }
    return -1;
}