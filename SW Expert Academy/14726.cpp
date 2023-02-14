#include<cstdio>
#include<vector>
#include<cmath>
#define INF 2e9
using namespace std;
typedef long long ll;

int t, n, q, m, length, a, b;
vector<ll> A;
ll x;

struct Tree {
	vector<ll> tree;
	Tree(int n) { tree.resize(n); }

	ll customCompare(ll a, ll b, bool isMin) {
		if (isMin) return min(a, b);
		return max(a, b);
	}

	ll init(int left, int right, int node, bool isMin) {
		if (left == right) return tree[node] = A[left];
		return tree[node] = customCompare(init(left, (left + right) / 2, node * 2, isMin), init((left + right) / 2 + 1, right, node * 2 + 1, isMin), isMin);
	}

	ll query(int left, int right, int node_left, int node_right, int node, bool isMin) {
		if (left > node_right || right < node_left) return customCompare(INF, 0, !isMin);
		if (left <= node_left && node_right <= right) return tree[node];
		return customCompare(query(left, right, node_left, (node_left + node_right) / 2, node * 2, isMin), query(left, right, (node_left + node_right) / 2 + 1, node_right, node * 2 + 1, isMin), isMin);
	}

	ll update(int pos, ll diff, int node_left, int node_right, int node, bool isMin) {
		if (pos < node_left || node_right < pos) return tree[node];
		if (node_left == node_right) return tree[node] = diff;
		return tree[node] = customCompare(update(pos, diff, node_left, (node_left + node_right) / 2, node * 2, isMin), update(pos, diff, (node_left + node_right) / 2 + 1, node_right, node * 2 + 1, isMin), isMin);
	}
};

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &q);

		length = (int)ceil(log2(n));
		Tree max_tree((1 << (length + 1)));
		Tree min_tree((1 << (length + 1)));
		A.clear();
		for (int i = 0; i < n; i++) {
			scanf("%lld", &x);
			A.push_back(x);
		}

		max_tree.init(0, n - 1, 1, false);
		min_tree.init(0, n - 1, 1, true);
		printf("#%d ", tc);
		for (int i = 0; i < q; i++) {
			scanf("%d %d %d", &m, &a, &b);
			if (m) {
				ll maxValue = max_tree.query(a, b - 1, 0, n - 1, 1, false);
				ll minValue = min_tree.query(a, b - 1, 0, n - 1, 1, true);
				printf("%lld ", maxValue - minValue);
			}
			else {
				max_tree.update(a, b, 0, n - 1, 1, false);
				min_tree.update(a, b, 0, n - 1, 1, true);
			}

		}
		puts("");
	}
}