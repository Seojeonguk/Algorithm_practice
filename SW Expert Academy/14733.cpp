#include<cstdio>
#include<vector>
#include<cmath>
using namespace std;
typedef long long ll;

int t, n, q, m, length, a, b;

vector<ll> A;
ll x;

struct Tree {
	vector<ll> tree;
	Tree(int n) { tree.resize(n); }

	ll init(int left, int right, int node) {
		if (left == right) return tree[node] = (left & 1 ? A[left] : -A[left]);
		int middle = (left + right) / 2;
		return tree[node] = init(left, middle, node * 2) + init(middle + 1, right, node * 2 + 1);
	}

	ll query(int left, int right, int node_left, int node_right, int node) {
		if (left > node_right || right < node_left) return 0;
		if (left <= node_left && node_right <= right) return tree[node];
		int middle = (node_left + node_right) / 2;
		return query(left, right, node_left, middle, node * 2) + query(left, right, middle + 1, node_right, node * 2 + 1);
	}

	ll update(int pos, ll diff, int node_left, int node_right, int node) {
		if (pos < node_left || node_right < pos) return tree[node];
		if (node_left == node_right) return tree[node] = (node_left & 1 ? diff : -diff);
		int middle = (node_left + node_right) / 2;
		return tree[node] = update(pos, diff, node_left, middle, node * 2) + update(pos, diff, middle + 1, node_right, node * 2 + 1);
	}
};

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &q);

		length = (int)ceil(log2(n));

		Tree tree((1 << (length + 1)));
		A.clear();

		for (int i = 0; i < n; i++) {
			scanf("%lld", &x);
			A.push_back(x);
		}

		tree.init(0, n - 1, 1);
		printf("#%d ", tc);
		for (int i = 0; i < q; i++) {
			scanf("%d %d %d", &m, &a, &b);
			if (m) {
				ll value = tree.query(a, b - 1, 0, n - 1, 1);
				printf("%lld ", a & 1 ? value : -value);
			}
			else {
				tree.update(a, b, 0, n - 1, 1);
			}

		}
		puts("");
	}
}