#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
ll a[2005];

ll solve() {
	ll ret = 0;
	priority_queue<ll> pq;

	for (int i = 0; i < n; i++) {
		pq.push(a[i]);
		if (a[i] <= pq.top()) {
			ret += pq.top() - a[i];
			pq.pop();
			pq.push(a[i]);
		}
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%lld", &a[i]);

	ll ans1 = solve();

	reverse(a, a + n);
	
	ll ans2 = solve();

	printf("%lld\n", min(ans1,ans2));
}