#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
int n, x, y, z, m, qury, depth[100002];
pair<int, ll> f[100002][21];
vector<pair<int, int> > v[100002];
void get_tree() {
	queue<pair<int, int> > q;
	depth[1] = 1;
	q.push({ 1,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (auto next : v[outdata.first]) {
			if (next.first != f[outdata.first][0].first) {
				f[next.first][0].first = outdata.first;
				f[next.first][0].second = next.second;
				depth[next.first] = depth[outdata.first] + 1;
				q.push({ next });
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
		scanf("%d %d %d", &x, &y, &z);
		v[x].push_back({ y,z });
		v[y].push_back({ x,z });
	}

	get_tree();

	for (int i = 1; i < 21; i++)
		for (int j = 1; j <= n; j++) {
			f[j][i].first = f[f[j][i - 1].first][i - 1].first;
			if (f[j][i].first) f[j][i].second = f[f[j][i - 1].first][i - 1].second + f[j][i - 1].second;
		}

	for (scanf("%d", &m); m--;) {
		scanf("%d", &qury);
		if (qury == 1) {
			scanf("%d %d", &x, &y);
			ll ans = 0;
			if (depth[x] != depth[y]) {
				if (depth[x] < depth[y]) swap(x, y);
				for (int i = 20; i >= 0; i--) {
					if (depth[f[x][i].first] >= depth[y]) {
						ans += f[x][i].second;
						x = f[x][i].first;
					}
				}
			}

			if (x != y) {
				for (int i = 20; i >= 0; i--) {
					if (f[x][i].first != f[y][i].first) {
						ans += f[x][i].second + f[y][i].second;
						x = f[x][i].first, y = f[y][i].first;
					}
				}
			}
			if (x != y)ans += f[x][0].second + f[y][0].second;
			printf("%lld\n", ans);
		}
		else {
			scanf("%d %d %d", &x, &y, &z);
			z--;

			int tmp1 = x, tmp2 = y;
			if (depth[tmp1] != depth[tmp2]) {
				if (depth[tmp1] < depth[tmp2]) swap(tmp1, tmp2);
				for (int i = 20; i >= 0; i--) {
					if (depth[f[tmp1][i].first] >= depth[tmp2]) {
						tmp1 = f[tmp1][i].first;
					}
				}
			}

			int lca = tmp1;
			if (tmp1 != tmp2) {
				for (int i = 20; i >= 0; i--) {
					if (f[tmp1][i].first != f[tmp2][i].first) {
						tmp1 = f[tmp1][i].first, tmp2 = f[tmp2][i].first;
					}
				}
				lca = f[tmp1][0].first;
			}
			int low_depth = depth[lca];


			for (int i = 20; i >= 0; i--) {
				if (f[x][i].first) {
					if (z >= 1 << i && low_depth <= depth[f[x][i].first]) {
						z -= 1 << i;
						x = f[x][i].first;
					}
				}
			}
			if (z == 0) {
				printf("%d\n", x);
				continue;
			}
			for (int i = 20; i >= 0; i--) {
				if (f[y][i].first) {
					if (depth[f[y][i].first] - low_depth >= z) {
						y = f[y][i].first;
					}
				}
			}

			printf("%d\n", y);
		}
	}
}