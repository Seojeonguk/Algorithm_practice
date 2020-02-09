#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, st,x,y,cost;
vector<pair<int, int> > v[10002];
int d[10002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int t;
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d %d", &n, &m, &st);
		for (int i = 1; i <= n; i++) {
			v[i].clear();
			d[i] = -1;
		}

		for (int i = 0; i < m; i++) {
			scanf("%d %d %d", &x, &y, &cost);
			v[y].push_back({ x,cost });
		}

		priority_queue<pair<int, int> > q;
		q.push({ 0,st });
		int ans = 0,max_min=0;
		while (!q.empty()) {
			auto outdata = q.top();
			outdata.first = -outdata.first;
			q.pop();

			if (d[outdata.second] != -1) continue;
			d[outdata.second] = outdata.first;
			ans++;
			max_min = max(max_min, outdata.first);
			int size = v[outdata.second].size();
			for (int i = 0; i < size; i++) {
				if (d[v[outdata.second][i].first] != -1) continue;
				q.push({ -(outdata.first + v[outdata.second][i].second),v[outdata.second][i].first });
			}

		}
		printf("%d %d\n", ans, max_min);
	}
}
