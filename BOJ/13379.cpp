#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, c, m, c1, c2, d;
vector<pair<int, int> > v[100002];
int dist[100002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d", &c, &m);

		for (int i = 1; i <= c; i++) {
			dist[i] = -1;
			v[i].clear();
		}

		for (int i = 0; i < c - 1; i++) {
			scanf("%d %d %d", &c1, &c2, &d);
			v[c1].push_back({ c2,d });
			v[c2].push_back({ c1,d });
		}

		int max_dist = 0;
		queue<int> q;
		dist[1] = 0;
		q.push(1);

		while (!q.empty()) {
			int cur = q.front();
			q.pop();

			max_dist = max(max_dist, dist[cur]);

			for (pair<int, int> next : v[cur]) {
				if (dist[next.first] != -1) continue;
				dist[next.first] = dist[cur] + next.second;
				q.push(next.first);
			}
		}

		printf("%d\n", max_dist >= m ? max_dist : -1);
	}
}
