#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
bool isSelect[22];
pair<ll, ll> p[22];
ll ans;

void solve(int idx, int cnt) {
    if (cnt == n / 2) {
        pair<ll, ll> sum = { 0,0 };
        for (int i = 0; i < n; i++) {
            sum.first += (isSelect[i] ? 1L : -1L) * p[i].first;
            sum.second += (isSelect[i] ? 1L : -1L) * p[i].second;
        }
        ans = min(ans, sum.first * sum.first + sum.second * sum.second);
        return;
    }

    for (int i = idx+1; i < n; i++) {
        if (isSelect[i]) continue;
        isSelect[i] = true;
        solve(i, cnt + 1);
        isSelect[i] = false;
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        ans = INT64_MAX;
        scanf("%d", &n);

        for (int i = 0; i < n; i++)
            scanf("%lld %lld", &p[i].first, &p[i].second);

        solve(-1, 0);

        printf("%lf\n", sqrt(ans));
    }
}
