#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, sx, sy;
char rooms[22][22];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int solve() {
	queue<pair<int, int>> q;
	q.push({ sx,sy });
	rooms[sx][sy] = '#';
	int ret = 0;
	
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		ret++;

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + X[dir];
			int ny = y + Y[dir];

			if (isOut(nx, ny) || rooms[nx][ny] == '#')
				continue;

			rooms[nx][ny] = '#';
			q.push({ nx,ny });
		}
	}

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d %d", &m, &n)) {
		if (!m || !n) break;

		for (int i = 0; i < n; i++) {
			scanf(" %s", rooms[i]);
			for (int j = 0; j < m; j++)
				if (rooms[i][j] == '@')
					sx = i, sy = j;
		}

		printf("%d\n", solve());
	}
}
