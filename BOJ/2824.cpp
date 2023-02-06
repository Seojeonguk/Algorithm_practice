#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
int n, m, x;
ll ans = 1;
map<int, pair<int, int> > p;
vector<int> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int s = (int)sqrt(1000000000) + 1;
	vector<bool> chk(s, 0);

	for (int i = 2; i < s; i++)
		if (!chk[i]) {
			v.push_back(i);
			for (int j = i; j < s; j += i) chk[j] = true;
		}

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		for (int k = 0; x != 1 && k != v.size();) {
			if (x % v[k]) k++;
			else {
				if (p.find(v[k]) == p.end()) p[v[k]].first = 1;
				else p[v[k]].first++;
				x /= v[k];
			}
		}
		if (x != 1) {
			if (p.find(x) == p.end()) p[x].first = 1;
			else p[x].first++;
		}
	}
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &x);
		for (int k = 0; x != 1 && k != v.size();) {
			if (x % v[k]) k++;
			else {
				if (p.find(v[k]) == p.end()) p[v[k]].second = 1;
				else p[v[k]].second++;
				x /= v[k];
			}
		}
		if (x != 1) {
			if (p.find(x) == p.end()) p[x].second = 1;
			else p[x].second++;
		}
	}

	bool last = false;
	for (auto x : p) {
		int tmp = min(x.second.first, x.second.second);
		if (tmp) {
			for (int i = 0; i < tmp; i++) {
				ans *= x.first;
				if (ans >= 1000000000) last = true;
				ans %= 1000000000;
			}
		}
	}
	ans > 1000000000 || last ? printf("%09lld\n", ans % 1000000000) : printf("%lld\n", ans);
}