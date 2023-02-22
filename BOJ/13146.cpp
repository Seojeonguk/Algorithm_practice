#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
ll ans, x;
deque<ll> dq;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%lld", &x);
		if (dq.empty()) {
			dq.push_back(x);
			continue;
		}

		if (dq.back() < x) {
			ans += x - dq.back();
			while (!dq.empty() && dq.back() < x) {
				dq.pop_back();
			}
			dq.push_back(x);
		}
		else if(dq.back()>x) {
			dq.push_back(x);
		}
	}

	if (dq.size() > 1)
		ans += dq[0] - dq[dq.size() - 1];

	printf("%lld\n", ans);
}
