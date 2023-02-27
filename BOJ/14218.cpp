#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, a, b, q;
bool isConnect[1001][1001];
int dist[1001];

void solve() {
	memset(dist, -1, sizeof dist);
	queue<int> q;
	dist[1] = 0;
	q.push(1);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (int i = 1; i <= n; i++) {
			if (isConnect[now][i] && dist[i] == -1) {
				dist[i] = dist[now] + 1;
				q.push(i);
			}
		}
	}

	for (int i = 1; i <= n; i++)
		printf("%d ", dist[i]);
	puts("");
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &a, &b);
		isConnect[a][b] = isConnect[b][a] = true;
	}

	scanf("%d", &q);
	while (q--) {
		scanf("%d %d", &a, &b);
		isConnect[a][b] = isConnect[b][a] = true;
		solve();
	}
}
