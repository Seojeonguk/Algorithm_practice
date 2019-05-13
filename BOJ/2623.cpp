#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,k,x,prev_x;
int dist[1001];
vector<int> v[1001];
queue<int> q;
queue<int> ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d", &k);
		for (int j = 0; j < k; j++) {
			prev_x = x;
			scanf("%d", &x);
			v[prev_x].push_back(x);
			if(j)dist[x]++;
		}
	}

	for (int i = 1; i <= n; i++)
		if (!dist[i])
			q.push(i);

	while (!q.empty()) {
		int y = q.front();
		q.pop();

		ans.push(y);

		int si = v[y].size();

		for (int i = 0; i < si; i++) {
			dist[v[y][i]]--;

			if (!dist[v[y][i]])
				q.push(v[y][i]);
		}
	}

	if (ans.size() == n) {
		while (!ans.empty()) {
			printf("%d\n", ans.front());
			ans.pop();
		}
	}
	else puts("0");
}