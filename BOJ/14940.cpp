#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;


int n, m, sx, sy;
int maps[1001][1001], ans[1001][1001];
bool isVisit[1001][1001];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &maps[i][j]);
			if (maps[i][j] == 2)
				sx = i, sy = j;
		}
	}

	queue<pair<int, int> > q;
	q.push({ sx,sy });
	isVisit[sx][sy] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || !maps[nextX][nextY])
				continue;

			isVisit[nextX][nextY] = true;
			ans[nextX][nextY] = ans[x][y] + 1;
			q.push({ nextX,nextY });
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (sx == i && sy == j) printf("0 ");
			else printf("%d ", ans[i][j] ? ans[i][j] : maps[i][j] ? -1 : 0);
		}
		puts("");
	}
}
