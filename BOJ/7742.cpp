#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x, y, z, m, qury, depth[100002];
pair<int, int> f[100002][18];
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
	scanf("%d %d", &n, &m);
	for (int i = 1; i < n; i++) {
		scanf("%d %d %d", &x, &y, &z);
		v[x].push_back({ y,z });
		v[y].push_back({ x,z });
	}

	get_tree();

	for (int i = 1; i < 18; i++)
		for (int j = 1; j <= n; j++) {
			f[j][i].first = f[f[j][i - 1].first][i - 1].first;
			if (f[j][i].first) f[j][i].second = f[f[j][i - 1].first][i - 1].second + f[j][i - 1].second;
		}

	for (int k = 0; k < m; k++) {
		scanf("%d %d", &x, &y);
		int ans = 0;
		if (depth[x] != depth[y]) {
			if (depth[x] < depth[y]) swap(x, y);
			for (int i = 17; i >= 0; i--) {
				if (depth[f[x][i].first] >= depth[y]) {
					ans += f[x][i].second;
					x = f[x][i].first;
				}
			}
		}

		if (x != y) {
			for (int i = 17; i >= 0; i--) {
				if (f[x][i].first != f[y][i].first) {
					ans += f[x][i].second + f[y][i].second;
					x = f[x][i].first, y = f[y][i].first;
				}
			}
		}
		if (x != y)ans += f[x][0].second + f[y][0].second;
		printf("%d\n", ans);
	}
}