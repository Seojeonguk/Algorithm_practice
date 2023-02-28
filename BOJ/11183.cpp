#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m;
int soteholm[1002][1002];
bool isVisit[1002][1002];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(pair<int,int> p) {
	return p.first<0 || p.second<0 || p.first>n + 1 || p.second>m + 1;
}

void flow() {
	queue<pair<int, int> > q;
	isVisit[0][0] = true;
	q.push({ 0,0 });

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			pair<int, int> next = { cur.first + dir[i][0], cur.second + dir[i][1] };
			
			if (isOut(next) || isVisit[next.first][next.second] || soteholm[next.first][next.second])
				continue;
			isVisit[next.first][next.second] = true;
			q.push(next);
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= m; j++) 
			scanf("%1d", &soteholm[i][j]);

	flow();

	int ans = 0;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (isVisit[i][j]) continue;
			for (int k = 0; k < 4; k++) {
				int nextX = i + dir[k][0];
				int nextY = j + dir[k][1];

				ans += (isVisit[nextX][nextY] ? 1 : 0);
			}
		}
	}

	printf("%d\n", ans);
}
