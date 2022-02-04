#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,x,y;
vector<int> v[20002];
int visit[20001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(visit, -1, sizeof visit);
	scanf("%d %d", &n, &m);
	
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	priority_queue<pair<int, int> > pq;
	queue<int> q;
	q.push(1);
	visit[1] = 0;
	while (!q.empty()) {
		int idx = q.front();
		q.pop();
		pq.push({ visit[idx],idx });
		int size = v[idx].size();
		for (int i = 0; i < size; i++) {
			if (visit[v[idx][i]] == -1) {
				visit[v[idx][i]] = visit[idx] + 1;
				q.push(v[idx][i]);
			}
		}
	}

	auto t = pq.top();
	pq.pop();


	int cnt = 1;
	while (1) {
		if (t.first != pq.top().first) break;
		if (t.second > pq.top().second) t.second = pq.top().second;
		pq.pop();
		cnt++;
	}
	printf("%d %d %d", t.second, t.first, cnt);
}
