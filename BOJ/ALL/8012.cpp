#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
int n, m, x, y, depth[30002], f[30002][21];
vector<int> v[30002];
void get_tree() {
	queue<int> q;
	depth[1] = 1;
	q.push(1);
	while (!q.empty()) {
		int outdata = q.front();
		q.pop();

		for (int next : v[outdata]) {
			if (next != f[outdata][0]) {
				f[next][0] = outdata;
				depth[next] = depth[outdata] + 1;
				q.push(next);
			}
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 1; i < n; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	get_tree();

	for (int i = 1; i < 21; i++)
		for (int j = 1; j <= n; j++)
			f[j][i] = f[f[j][i - 1]][i - 1];

	x = 1;
	ll ans = 0;
	for (scanf("%d", &m); m--;) {
		scanf("%d", &y);
		int tmp1 = x, tmp2 = y;
		if (depth[tmp1] != depth[tmp2]) {
			if (depth[tmp1] < depth[tmp2]) swap(tmp1, tmp2);
			for (int i = 20; i >= 0; i--) {
				if (depth[f[tmp1][i]] >= depth[tmp2])
					tmp1 = f[tmp1][i];
			}
		}
		int lca = tmp1;
		if (tmp1 != tmp2) {
			for (int i = 20; i >= 0; i--) {
				if (f[tmp1][i] != f[tmp2][i]) {
					tmp1 = f[tmp1][i], tmp2 = f[tmp2][i];
				}
			}
			lca = f[tmp1][0];
		}
		ans += depth[x] + depth[y] - 2 * depth[lca];
		x = y;
	}
	printf("%lld\n", ans);
}