#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int arr[502][502], n, m, x, y, cost, st, de;
int d[502];

void solve() {
	memset(d, -1, sizeof d);
	priority_queue<pair<int, int> > q;
	q.push({ 0,st });
	while (!q.empty()) {
		auto outdata = q.top();
		outdata.first = -outdata.first;
		q.pop();

		if (d[outdata.second] != -1) continue;
		d[outdata.second] = outdata.first;
		for (int i = 0; i < n; i++) {
			if (arr[outdata.second][i] == -1) continue;
			if (d[i] != -1) continue;
			q.push({ -(outdata.first + arr[outdata.second][i]),i });
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &n, &m);
		if (!n && !m) break;
		memset(arr, -1, sizeof arr);
		scanf("%d %d", &st, &de);
		for (int i = 0; i < m; i++) {
			scanf("%d %d %d", &x, &y, &cost);
			arr[x][y] = cost;
		}
		solve();
		queue<int> q;
		q.push(de);
		while (!q.empty()) {
			int idx = q.front();
			q.pop();

			for (int i = 0; i < n; i++)
				if ((arr[i][idx] != -1) && (d[idx] == (d[i] + arr[i][idx]))) {
					arr[i][idx] = -1;
					q.push(i);
				}
		}
		solve();

		printf("%d\n", d[de]);
	}
}