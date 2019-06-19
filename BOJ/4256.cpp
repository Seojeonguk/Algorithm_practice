#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n;
pair<int, int> order_arr[1002];
int arr[1002];
pair<int, int> _tree[1002];

void solve(int idx) {
	if (_tree[idx].first != -1) solve(_tree[idx].first);
	if (_tree[idx].second != -1) solve(_tree[idx].second);
	printf("%d ", idx);
}

int make_tree(int l, int r) {
	if (l > r) return -1;
	int min_cost = 9999, min_idx=0,j=0;
	for (int i = l; i <= r; i++) {
		int idx = order_arr[i].second;
		if (min_cost > arr[idx]) {
			min_cost = arr[idx];
			min_idx = idx;
			j = i;
		}

	}
	_tree[min_idx].first = make_tree(l, j - 1);
	_tree[min_idx].second = make_tree(j+1, r);
	return min_idx;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		int cnt = 0;
		memset(order_arr, 0, sizeof order_arr);
		memset(_tree, 0, sizeof _tree);
		memset(arr, 0, sizeof arr);
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			scanf("%d", &order_arr[i].first);
			arr[order_arr[i].first] = ++cnt;
		}
		for (int i = 0; i < n; i++) scanf("%d", &order_arr[i].second);

		make_tree(0, n - 1);
		solve(order_arr[0].first);
		puts("");
	}
}