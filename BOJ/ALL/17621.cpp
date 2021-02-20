#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
ll n, w, coin, cost;
stack<ll> s;

void solve() {
	ll top = s.top();
	ll buy = top;
	while (!s.empty()) {
		buy = s.top();
		s.pop();
	}
	w = w % buy + top * (w / buy);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &n, &w);

	for (int i = 0; i < n; i++) {
		scanf("%lld", &cost);
		if (s.empty() || s.top()<cost) s.push(cost);
		else {
			solve();
			s.push(cost);
		}
	}
	solve();

	printf("%lld\n", w);
}