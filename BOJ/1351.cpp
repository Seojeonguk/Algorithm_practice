#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
ll n, p, q;
map<ll, ll> m;
ll dp(ll x) {
	auto it = m.find(x);
	if (it != m.end()) return it->second;

	m.insert({ x, dp(x / p) + dp(x / q) });
	return dp(x / p) + dp(x / q);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld %lld", &n, &p, &q);
	m.insert({ 0, 1 });
	dp(n);
	printf("%lld\n", m.find(n)->second);
}