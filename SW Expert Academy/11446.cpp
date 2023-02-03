#include<cstdio>
using namespace std;
typedef long long ll;

int t, n;
ll a[100], m;

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %lld", &n, &m);

		for (int i = 0; i < n; i++)
			scanf("%lld", &a[i]);

		ll l = 1, r = 1e18;

		while (l <= r) {
			ll mid = (l + r) / 2;

			ll cnt = 0;

			for (int i = 0; i < n; i++)
				cnt += (a[i] / mid);

			if (cnt >= m) l = mid + 1;
			else r = mid - 1;
		}


		printf("#%d %lld\n", tc, r);
	}
}