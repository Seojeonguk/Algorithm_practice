#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
vector <pair<int, int> > v[1001];
int go[1001][1001];
int st, de,cost;
int dist[1001];
priority_queue<pair<int, int> > pq;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 1001; i++) {
		dist[i] = INT_MAX;
		for (int j = 0; j < 1001; j++)
			go[i][j] = INT_MAX;
	}
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &st, &de, &cost);
		go[st][de] = min(go[st][de], cost);
	}
	
	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= n; j++) 
			if (go[i][j] != INT_MAX) 
				v[i].push_back({ go[i][j],j });

	scanf("%d %d", &st, &de);

	dist[st] = 0;
	pq.push({ 0,st });

	while (!pq.empty()) {
		auto outdata = pq.top();
		pq.pop();

		int size = v[outdata.second].size();
		for (int i = 0; i < size; i++) {
			int next = v[outdata.second][i].second;
			int nextCost = -outdata.first + v[outdata.second][i].first;

			if (dist[next] > nextCost) {
				dist[next] = nextCost;
				pq.push({ -nextCost,next });
			}
		}
	}

	printf("%d\n", dist[de]);
}