#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
ll n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%lld", &n);
		if (!n) break;
		if (n < 3) puts("hi");
		ll ans = n;
		for (ll i = 2; i*i <= n; i++) {
			if (n%i == 0) {
				while (n%i == 0) n /= i;
				ans -= ans / i;
			}
		}
		if (n > 1) ans -= ans / n;
		printf("%lld\n", ans);
	}
}
