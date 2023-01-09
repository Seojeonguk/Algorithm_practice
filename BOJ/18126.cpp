#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, a, b;
ll c;
vector<pair<int, ll> > v[5002];
bool isVisit[5002];

ll solve() {
    ll ans = 0;
    queue<pair<int, ll> > q;
    q.push({ 1,0 });
    isVisit[1] = true;

    while (!q.empty()) {
        auto now = q.front();
        q.pop();

        ans = max(ans, now.second);

        for (pair<int,ll> next : v[now.first]) {
            if (isVisit[next.first]) continue;
            isVisit[next.first] = true;
            q.push({ next.first, now.second + next.second });
        }
    }

    return ans;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n - 1; i++) {
        scanf("%d %d %lld", &a, &b, &c);
        v[a].push_back({ b,c });
        v[b].push_back({ a,c });
    }

    printf("%lld\n", solve());
}
