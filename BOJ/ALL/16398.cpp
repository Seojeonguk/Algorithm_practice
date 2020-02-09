#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x;
long ans = (long)(100000000000);
priority_queue<pair<int, int> > q;
vector<pair<int,int> > v[1002];
int visit[1002];

int solve(int st) {
	long ret = 0;
	memset(visit, -1, sizeof visit);
	q.push({ 0,st });

	while (!q.empty()) {
		int out_cost = -q.top().first;
		int out_idx = q.top().second;
		q.pop();
		if (visit[out_idx] != -1) continue;
		visit[out_idx] = out_cost;
		ret += (long)out_cost;
		for (int i = 0; i < n - 1; i++) {
			if (visit[v[out_idx][i].first] != -1)continue;
			q.push({ -v[out_idx][i].second,v[out_idx][i].first });
		}
	}
	ans = min(ans, ret);
	return ret;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &x);
			if (x) v[i].push_back({ j,x });
		}
	}

	solve(1);

	printf("%ld\n", ans);
}