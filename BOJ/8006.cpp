#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, k, from, to, cost, d[101][101][101];
vector<pair<int, int> > v[1001];
priority_queue<pair<int, int> > q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &from, &to, &cost);
		v[from].push_back({ to, cost });
	}

	for (int tmp = 1; tmp <= n; tmp++) {
		priority_queue<int> chk[101];
		k = 100;
		q.push({ 0, tmp });
		while (!q.empty()) {
			int now = q.top().second, now_cost = -q.top().first;
			q.pop();
			for (auto x : v[now]) {
				int next = x.first, next_cost = x.second;
				if (chk[next].size() < k || chk[next].top() > now_cost + next_cost) {
					if (chk[next].size() > k) chk[next].pop();
					chk[next].push(next_cost + now_cost);
					q.push({ -next_cost - now_cost,next });
				}
			}
		}
		for (int i = 1; i <= n; i++)
			for (int j = chk[i].size(); j >= 1; j--)
				d[tmp][i][j] = chk[i].top(), chk[i].pop();
	}

	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &from, &to, &cost);
		printf("%d\n", d[from][to][cost] ? d[from][to][cost] : -1);
	}
}