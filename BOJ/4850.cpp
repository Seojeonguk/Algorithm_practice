#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, w, d, total;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (scanf("%lld %lld %lld %lld", &n, &w, &d, &total) != EOF) {
        ll sum = w * ((n * (n - 1)) / 2);

        ll ans = n;
        for (ll i = 1; i < n; i++) {
            if (sum - d * i == total) {
                ans = i;
                break;
            }
        }
        printf("%lld\n", ans);
    }
}
