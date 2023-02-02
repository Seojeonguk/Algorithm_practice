#include<cstdio>
#include<algorithm>
using namespace std;
typedef long long ll;

int t;
ll a, b, k, mod;

ll exponentiations(ll a, ll b) {
	if (!b) return 1;
	ll exponentiation = exponentiations(a, b / 2);
	ll ret = (exponentiation * exponentiation) % mod;
	if (b & 1) ret = (ret * a) % mod;
	return ret;
}

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%lld %lld %lld", &a, &b, &k);
		
		mod = a + b;

		ll ans = (exponentiations(2, k) * a) % mod;

		printf("#%d %lld\n", tc, min(ans, mod - ans));
	}
}