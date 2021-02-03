#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,a,b,c,st,en,cnt;
vector<pair<int,int> > v[10002];
vector<pair<int, int> > v2[10002];
int d[10002];
int max_cost[10002];
bool visit[10002];

void solve(int idx) {
	if (visit[idx]) return;
	visit[idx] = true;
	int size = v2[idx].size();
	for (int i = 0; i < size; i++) {
		int next = v2[idx][i].first;
		int next_cost = v2[idx][i].second;

		if (max_cost[idx] == max_cost[next] + next_cost) {
			solve(next);
			cnt++;
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &a, &b, &c);
		v[a].push_back({ b,c });
		v2[b].push_back({ a,c });
		d[b]++;
	}

	scanf("%d %d", &st, &en);
	
	queue<int> q;
	q.push(st);

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		int size = v[outdata].size();
		for (int i = 0; i < size; i++) {
			int idx = v[outdata][i].first;
			int cost = v[outdata][i].second;

			max_cost[idx] = max(max_cost[idx], max_cost[outdata] + cost);
			d[idx]--;
			if (d[idx] == 0) q.push(idx);
		}
	}

	solve(en);

	printf("%d\n%d", max_cost[en], cnt);
}