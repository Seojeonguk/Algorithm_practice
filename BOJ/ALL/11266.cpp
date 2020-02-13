#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, x, y, visit_order[10002], order;
vector<int> v[10002];
set<int> s;

int solve(int idx, bool root) {
	visit_order[idx] = ++order;
	int child = 0, low = visit_order[idx];
	for (int next : v[idx]) {
		if (!visit_order[next]) {
			child++;
			int tmp = solve(next, 0);
			if (!root && visit_order[idx] <= tmp) s.insert(idx);
			low = min(low, tmp);
		}
		else low = min(low, visit_order[next]);
	}
	if (root && child > 1) s.insert(idx);
	return low;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	for (int i = 1; i <= n; i++)
		if (!visit_order[i])
			solve(i, 1);

	printf("%d\n", s.size());
	for (int x : s) printf("%d ", x);
}