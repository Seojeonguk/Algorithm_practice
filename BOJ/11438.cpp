#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, x, y, depth[100002], d[100002][21];
vector<int> v[100001];

void make_tree(int here, int parent) {
	depth[here] = depth[parent] + 1;
	d[here][0] = parent;
	for (int next : v[here]) {
		if (next != parent)
			make_tree(next, here);
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n - 1; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}
	make_tree(1, 0);

	for (int j = 1; j < 21; j++)
		for (int i = 1; i <= n; i++)
			d[i][j] = d[d[i][j - 1]][j - 1];

	for (scanf("%d", &m); m--;) {
		scanf("%d %d", &x, &y);
		if (depth[x] != depth[y]) {
			if (depth[x] > depth[y]) swap(x, y);
			for (int i = 20; i >= 0; i--)
				if (depth[x] <= depth[d[y][i]])
					y = d[y][i];
		}

		int ans = x;
		if (x != y) {
			for (int i = 20; i >= 0; i--) {
				if (d[x][i] != d[y][i]) {
					x = d[x][i];
					y = d[y][i];
				}
				ans = d[x][i];
			}
		}

		printf("%d\n", ans);
	}
}