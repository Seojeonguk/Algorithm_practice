#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k, x, y, z;
vector<pair<int, int> > v[20001];
int dist[20001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	for (int i = 1; i <= n; i++) dist[i] = 1 << 30;
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &x, &y, &z);
		v[x].push_back({ z,y });
	}
	for (int i = 1; i <= n; i++) sort(v[i].begin(), v[i].end());

	priority_queue<pair<int, int> > q;
	dist[k] = 0;
	q.push({ 0,k });
	while (!q.empty()) {
		auto outdata = q.top();
		q.pop();

		for (auto next : v[outdata.second]) {
			if (next.first + dist[outdata.second] < dist[next.second]) {
				dist[next.second] = next.first + dist[outdata.second];
				q.push({ -next.first - dist[outdata.second],next.second });
			}
		}

	}
	for (int i = 1; i <= n; i++)
		dist[i] == 1 << 30 ? puts("INF") : printf("%d\n", dist[i]);
}