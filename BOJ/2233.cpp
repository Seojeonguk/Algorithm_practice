#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;


pair<int, int> comma[2002];
string s = ""; int par[2002], depth[2002], n, f[2002][21], x, y;
void get_tree() {
	int parent = -1, node_num = 0, now_num = 0;
	int size = s.length();
	for (int i = 0; i < size; i++) {
		if (s[i] == '0') {
			parent = now_num;
			f[node_num][0] = par[++node_num] = parent;
			now_num = node_num;
			depth[node_num] = depth[parent] + 1;
			comma[now_num].first = i + 1;
			if (i + 1 == x) x = now_num;
			if (i + 1 == y) y = now_num;
		}
		else {
			if (i + 1 == x) x = now_num;
			if (i + 1 == y) y = now_num;
			comma[now_num].second = i + 1;
			now_num = parent;
			parent = par[parent];
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	cin >> s;
	scanf("%d %d", &x, &y);

	get_tree();

	for (int i = 1; i < 21; i++)
		for (int j = 1; j <= n; j++)
			f[j][i] = f[f[j][i - 1]][i - 1];
	if (depth[x] != depth[y]) {
		if (depth[x] < depth[y]) swap(x, y);
		for (int i = 20; i >= 0; i--) {
			if (depth[f[x][i]] >= depth[y])
				x = f[x][i];
		}
	}
	int ans = x;
	if (x != y) {
		for (int i = 20; i >= 0; i--) {
			if (f[x][i] != f[y][i]) {
				x = f[x][i];
				y = f[y][i];
			}
			ans = f[x][i];
		}
	}

	printf("%d %d\n", comma[ans].first, comma[ans].second);
}