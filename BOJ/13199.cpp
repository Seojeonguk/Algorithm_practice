#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
ll price, money, require, add_coupon;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%lld %lld %lld %lld", &price, &money, &require, &add_coupon);

		ll coupon = (money / price) * add_coupon;

		coupon = (coupon % require) + ((coupon / require) * add_coupon);

		coupon -= require;

		ll ans = 0;

		if (coupon >= 0)
			ans = 1 + coupon / (require - add_coupon);

		printf("%lld\n", ans);
	}
}
