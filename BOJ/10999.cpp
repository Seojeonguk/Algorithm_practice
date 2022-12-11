#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

int n, m, k, length;
vector<ll> A;
vector<ll> lazy;

struct lazy_tree {
	vector<ll> tree;
	lazy_tree(int n) { tree.resize(n); }

	ll init(int left, int right, int node) {
		if (left == right)
			return tree[node] = A[left];

		return tree[node] = init(left, (left + right) / 2, node * 2) + init((left + right) / 2 + 1, right, node * 2 + 1);
	}
	void update_lazy(int node_left, int node_right, int node) {
		if (lazy[node] != 0) {
			tree[node] += (node_right - node_left + 1) * lazy[node];
			if (node_left != node_right) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}
	void update_range(ll diff, int node_left, int node_right, int left, int right, int node) {
		update_lazy(node_left, node_right, node);
		if (left > node_right || right < node_left) return;
		if (left <= node_left && node_right <= right) {
			tree[node] += (node_right - node_left + 1) * diff;
			if (node_left != node_right) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			return;
		}
		update_range(diff, node_left, (node_left + node_right) / 2, left, right, node * 2);
		update_range(diff, (node_left + node_right) / 2 + 1, node_right, left, right, node * 2 + 1);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	long long sum(int start, int end, int left, int right, int node) {
		update_lazy(start, end, node);
		if (left > end || right < start) return 0;
		if (left <= start && end <= right) return tree[node];
		return sum(start, (start + end) / 2, left, right, node * 2) + sum((start + end) / 2 + 1, end, left, right, node * 2 + 1);
	}
};

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	length = (int)ceil(log2(n));
	length = (1 << (length + 1));
	lazy_tree tree(length);
	lazy.resize(length);

	for (ll x, i = 0; i < n; i++) {
		scanf("%lld", &x);
		A.push_back(x);
	}

	tree.init(0, n - 1, 1);

	for (int i = 0, mode, l, r; i < m + k; i++) {
		ll value;
		scanf("%d", &mode);
		if (mode & 1) {
			scanf("%d %d %lld", &l, &r, &value);
			tree.update_range(value, 0, n - 1, l - 1, r - 1, 1);
		}
		else {
			scanf("%d %d", &l, &r);
			printf("%lld\n", tree.sum(0, n - 1, l - 1, r - 1, 1));
		}
	}
}