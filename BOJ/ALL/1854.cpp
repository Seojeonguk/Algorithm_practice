#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, k;
int from, to, cost;
vector<pair<int, int> > v[1001];
priority_queue<pair<int, int> > q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &from, &to, &cost);
		v[from].push_back({ to, cost });
	}
	vector<priority_queue<int> > ans(n + 1);
	ans[1].push(0);
	q.push({ 0, 1 });

	while (!q.empty()) {
		int now = q.top().second, now_cost = -q.top().first;
		q.pop();

		for (auto x : v[now]) {
			int next = x.first, next_cost = x.second;
			if (ans[next].size() < k || ans[next].top() > now_cost + next_cost) {
				ans[next].push(next_cost + now_cost);
				if (ans[next].size() > k) ans[next].pop();
				q.push({ -(now_cost + next_cost), next });
			}
		}
	}

	for (int i = 1; i <= n; i++)
		printf("%d\n", ans[i].size() < k ? -1 : ans[i].top());
}