#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, x, y, c, depth[100002];
vector<pair<int, int> > v[100001];
pair<int, pair<int, int> > d[100002][21];

void make_tree(int here, int parent, int cost) {
	depth[here] = depth[parent] + 1;
	d[here][0].first = parent;
	d[here][0].second.first = d[here][0].second.second = cost;
	for (auto next : v[here]) {
		if (next.first != parent)
			make_tree(next.first, here, next.second);
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n - 1; i++) {
		scanf("%d %d %d", &x, &y, &c);
		v[x].push_back({ y,c });
		v[y].push_back({ x,c });
	}
	make_tree(1, 0, 0);
	for (int j = 1; j < 21; j++)
		for (int i = 1; i <= n; i++) {
			d[i][j].first = d[d[i][j - 1].first][j - 1].first;
			if (!d[i][j].first) continue;
			d[i][j].second.first = max(d[i][j - 1].second.first, d[d[i][j - 1].first][j - 1].second.first);
			d[i][j].second.second = min(d[i][j - 1].second.second, d[d[i][j - 1].first][j - 1].second.second);
		}

	for (scanf("%d", &m); m--;) {
		int _min = 9999999, _max = 0;
		scanf("%d %d", &x, &y);
		if (depth[x] != depth[y]) {
			if (depth[x] > depth[y]) swap(x, y);
			for (int i = 20; i >= 0; i--)
				if (depth[x] <= depth[d[y][i].first]) {
					_min = min(_min, d[y][i].second.second);
					_max = max(_max, d[y][i].second.first);
					y = d[y][i].first;
				}
		}
		if (x != y) {
			for (int i = 20; i >= 0; i--) {
				if (d[x][i].first != d[y][i].first) {
					_max = max(_max, max(d[y][i].second.first, d[x][i].second.first));
					_min = min(_min, min(d[x][i].second.second ? d[x][i].second.second : 9999999, d[y][i].second.second ? d[y][i].second.second : 999999));
					x = d[x][i].first;
					y = d[y][i].first;
				}
			}
			_min = min(_min, min(d[x][0].second.second ? d[x][0].second.second : 9999999, d[y][0].second.second ? d[y][0].second.second : 999999));
			_max = max(_max, max(d[y][0].second.first, d[x][0].second.first));
		}
		printf("%d %d\n", _min, _max);
	}
}