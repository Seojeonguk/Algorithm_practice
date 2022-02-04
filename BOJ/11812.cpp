#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

typedef long long int ll;
ll n, k, q, x, y;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld %lld", &n,&k,&q);

	for (int i = 0; i < q; i++) {
		scanf("%lld %lld", &x, &y);
		if (k == 1) {
			printf("%lld\n", abs(x - y));
			continue;
		}
		ll ans = 0;
		while (x != y) {
			if (x < y) swap(x, y);
			x = (x - 2) / k + 1;
			ans++;
		}
		printf("%lld\n", ans);
	}
}