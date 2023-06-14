#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, k;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &n, &k);

    ll l = 1, r = n * n;

    while (l <= r) {
        ll mid = (l + r) / 2;

        ll cnt = 0;
        for (ll i = 1; i <= n; i++) 
            cnt += min(mid / i, n);

        if (cnt >= k) r = mid - 1;
        else l = mid + 1;
    }

    printf("%lld\n", l);
}