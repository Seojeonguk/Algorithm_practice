#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define pipii pair<int,pair<int,int> >
int t, n, m, sx, sy;
char wall_maria[103][103];
bool canMove[103][103][4], isVisit[103][103];
int dir[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int solve() {
	queue<pipii> q;
	q.push({ 0,{sx,sy} });
	isVisit[sx][sy] = true;

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (x == 0 || y == 0 || x == n - 1 || y == m - 1)
			return cnt;

		if (cnt == t) continue;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || !canMove[nextX][nextY][i]) continue;
			isVisit[nextX][nextY] = true;
			q.push({ cnt + 1,{nextX,nextY} });
		}
	}

	return -1;
}

void calMove(int x, int y) {
	if (wall_maria[x][y] == 'U' || wall_maria[x][y] == '0')
		canMove[x][y][0] = true;

	if (wall_maria[x][y] == 'D' || wall_maria[x][y] == '0')
		canMove[x][y][1] = true;

	if (wall_maria[x][y] == 'L' || wall_maria[x][y] == '0')
		canMove[x][y][2] = true;

	if (wall_maria[x][y] == 'R' || wall_maria[x][y] == '0')
		canMove[x][y][3] = true;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &t, &n, &m);

	for (int i = 0; i < n; i++) {
		scanf(" %s", wall_maria[i]);
		for (int j = 0; j < m; j++) {
			if (wall_maria[i][j] == 'S')
				sx = i, sy = j;
			calMove(i, j);
		}
	}

	int ans = solve();
	if (ans == -1) puts("NOT POSSIBLE");
	else printf("%d\n", ans);
}
