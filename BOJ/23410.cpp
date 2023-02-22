#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll mod = (1LL << 32);
int t;

bool solve(ll x,ll y) {
	set<ll> s;
	queue<ll> q;

	s.insert(x);
	q.push(x);

	while (!q.empty()) {
		ll now = q.front();
		q.pop();

		if (now == y)
			return true;

		ll next = (now << 1) % mod;
		if (s.find(next) == s.end()) {
			s.insert(next);
			q.push(next);
		}
		next = (now >> 1) % mod;
		if (s.find(next) == s.end()) {
			s.insert(next);
			q.push(next);
		}
	}
	return false;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		ll x, y;
		scanf("%lld %lld", &x, &y);

		bool possible = solve(x,y);

		puts(possible ? "Yes" : "No");
	}
}
