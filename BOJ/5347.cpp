#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
ll a, b;

ll gcd(ll x,ll y) {
	if (!y) return x;
	return gcd(y, x % y);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%lld %lld", &a, &b);
		ll ans = a * b / gcd(a, b);

		printf("%lld\n", ans);
	}
}
