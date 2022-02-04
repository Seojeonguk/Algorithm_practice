#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, d[502], cost[502], x, res[502];
vector<int> v[502];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	queue<int> q;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &cost[i]);

		while (1) {
			scanf("%d", &x);
			if (x == -1) break;
			d[i]++;
			v[x].push_back(i);
		}
		if (!d[i]) {
			q.push(i);
			res[i] = cost[i];
		}
	}

	while (!q.empty()) {
		int outdata = q.front();
		q.pop();

		int size = v[outdata].size();
		for (int i = 0; i < size; i++) {
			res[v[outdata][i]] = max(res[v[outdata][i]], res[outdata] + cost[v[outdata][i]]);
			if (!--d[v[outdata][i]]) {
				q.push(v[outdata][i]);
			}
		}
	}

	for (int i = 1; i <= n; i++) printf("%d\n", res[i]);
}