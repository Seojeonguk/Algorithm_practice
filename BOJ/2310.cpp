#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,moveRoom;
bool visit[1002][1002];
int cost[1002];
char c;
bool dfs(int, int);

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if (!n) break;

		memset(visit, false, sizeof visit);
		memset(cost, 0, sizeof cost);
		
		vector<int> v[1002];
		v[0].push_back(1);

		for (int i = 1; i <= n; i++) {
			scanf(" %c %d", &c, &cost[i]);
			if (c == 'T') cost[i] = -cost[i];
			while (1) {
				scanf("%d", &moveRoom);
				if (!moveRoom) break;
				v[i].push_back(moveRoom);
			}
		}
		bool ret = false;
		queue<pair<int, int> > q;
		q.push({ 0,0 });
		while (!q.empty()) {
			auto outdata = q.front();
			q.pop();

			if (outdata.first == n) {
				ret = true;
				break;
			}

			int nextSize = v[outdata.first].size();
			for (int i = 0; i < nextSize; i++) {
				int nextRoom = v[outdata.first][i];
				int nextCost = outdata.second;
				if (cost[nextRoom] > 0 && outdata.second < cost[nextRoom])
					nextCost = cost[nextRoom];
				if (cost[nextRoom] < 0)
					nextCost = outdata.second + cost[nextRoom];
				if (visit[nextRoom][nextCost] || nextCost < 0) continue;
				visit[nextRoom][nextCost] = true;
				q.push({ nextRoom,nextCost });
			}
		}
		puts(ret ? "Yes" : "No");
	}
}