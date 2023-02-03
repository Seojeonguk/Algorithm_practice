#include<cstdio>
using namespace std;
typedef long long ll;

int t;
ll n;

ll solve() {
	ll l = 1, r = 10000000000;

	while (l <= r) {
		ll mid = (l + r) / 2;

		ll k = (mid * (mid + 1)) / 2;

		if (k == n) return mid;

		if (k < n) l = mid + 1;
		else r = mid - 1;
	}

	return -1;
}

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%lld", &n);

		ll ans = solve();

		printf("#%d %lld\n", tc, ans);
	}
}