#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, k, ans;
ll arr[10];

void solve(ll x) {
    ans = max(ans, x);

    for (int i = 0; i < k; i++) {
        ll nextValue = x * 10 + arr[i];
        if (nextValue > n) continue;
        solve(nextValue);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &n, &k);

    for (int i = 0; i < k; i++)
        scanf("%lld", &arr[i]);

    solve(0);

    printf("%lld\n", ans);
}
