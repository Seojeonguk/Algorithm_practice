#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
using ll = long long;

vector<ll> A;
int n, m, length;
struct Tree {
	vector<ll> tree;
	Tree(int n) { tree.resize(n); }

	ll init(int left, int right, int node) {
		if (left == right)
			return tree[node] = A[left];

		return tree[node] = init(left, (left + right) / 2, node * 2) + init((left + right) / 2 + 1, right, node * 2 + 1);
	}

	ll query(int left, int right, int node_left, int node_right, int node) {
		if (left > node_right || right < node_left) return 0;
		if (left <= node_left && node_right <= right) return tree[node];
		return query(left, right, node_left, (node_left + node_right) / 2, node * 2) + query(left, right, (node_left + node_right) / 2 + 1, node_right, node * 2 + 1);
	}

	ll update(int pos, ll diff, int node_left, int node_right, int node) {
		if (pos < node_left || node_right < pos) return tree[node];
		if (node_left == node_right) return tree[node] = diff;
		return tree[node] = update(pos, diff, node_left, (node_left + node_right) / 2, node * 2) + update(pos, diff, (node_left + node_right) / 2 + 1, node_right, node * 2 + 1);
	}
};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	
	length = 22;
	Tree tree((1 << (length + 1)) - 1);

	A.resize(n);

	tree.init(0, n - 1, 1);

	for (int i = 0, mode, l, r, pos; i < m; i++) {
		ll value;
		scanf("%d", &mode);
		if (mode) {
			scanf("%d %lld", &pos, &value);
			tree.update(pos - 1, value, 0, n - 1, 1);
		}
		else {
			scanf("%d %d", &l, &r);
			if (l > r) swap(l, r);
			printf("%lld\n", tree.query(l - 1, r - 1, 0, n - 1, 1));
		}
	}
}