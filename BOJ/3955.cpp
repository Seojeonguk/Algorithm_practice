#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
#define MAX 1000000000
typedef long long ll;
int t;
ll k, c;
ll gcd(ll x, ll y) {
	if (y == 0) return x;
	return gcd(y, x%y);
}

ll egcd(ll a, ll b) {
	ll r, q, tmp = a, t, t1 = 0, t2 = 1;
	while (b) {
		q = a / b;
		r = a % b;
		t = t1 - q * t2;
		a = b;
		b = r;
		t1 = t2;
		t2 = t;
	}
	while (t1 < 0) t1 += tmp;
	return t1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%lld %lld", &k, &c);
		if (gcd(k, c) != 1) {
			puts("IMPOSSIBLE");
			continue;
		}
		if (c == 1) {
			if (k + 1 > 1e9) puts("IMPOSSIBLE");
			else printf("%lld\n", k + 1);
			continue;
		}
		if (k == 1) {
			puts("1");
			continue;
		}

		ll ans = egcd(k, c);
		if (ans > 1e9) puts("IMPOSSIBLE");
		else printf("%lld\n", ans);
	}
}