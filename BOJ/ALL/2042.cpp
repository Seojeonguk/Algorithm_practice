#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
int n, m, k, h, a, b, c;
vector<ll> v;

ll init(int l, int r, int node) {
	if (l == r) return v[node];
	int mid = (l + r) / 2;
	return v[node] = init(l, mid, node * 2) + init(mid + 1, r, node * 2 + 1);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	for (h = 1; h < n; h <<= 1) {}

	v.resize(h * 2, 0);
	for (int i = 0; i < n; i++) scanf("%lld", &v[h + i]);
	init(1, h, 1);

	for (int i = 0; i < m + k; i++) {
		scanf("%d %d %d", &a, &b, &c);
		if (a == 1) {
			ll diff = c - v[h + b - 1];
			for (int idx = h + b - 1; idx; idx /= 2) v[idx] += diff;
		}
		else {
			ll ans = 0;
			int l = h + b - 1, r = h + c - 1;
			while (l <= r) {
				if (l % 2) ans += v[l++];
				if (r % 2 == 0) ans += v[r--];

				l /= 2;
				r /= 2;
			}
			printf("%lld\n", ans);
		}
	}
}