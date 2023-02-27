#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int h, n, m, sx, sy, sz, ex, ey, ez;

struct state {
	int z, x, y, cnt;
};

char mazes[64][64][64];
bool isVisit[64][64][64];

int dir[5][3] = { {-1,0,0}, {1,0,0},{0,-1,0},{0,1,0},{0,0,1} };

bool isOut(int z, int x, int y) {
	return x<0 || y<0 || z<0 || x>n - 1 || y> m - 1 || z>h - 1;
}

int solve() {
	queue<state> q;
	isVisit[sz][sx][sy] = true;
	q.push({ sz,sx,sy,0 });
	
	while (!q.empty()) {
		state now = q.front();
		q.pop();

		if (now.x == ex && now.y == ey && now.z == ez)
			return now.cnt;

		for (int i = 0; i < 5; i++) {
			int nextX = now.x + dir[i][0];
			int nextY = now.y + dir[i][1];
			int nextZ = now.z + dir[i][2];

			if (isOut(nextZ, nextX, nextY) || isVisit[nextZ][nextX][nextY] || mazes[nextZ][nextX][nextY] == 'o') continue;
			isVisit[nextZ][nextX][nextY] = true;
			q.push({ nextZ, nextX, nextY,now.cnt + 1 });
		}
	}

	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &h, &n, &m);

	for (int k = 0; k < h; k++) {
		for (int i = 0; i < n; i++) {
			scanf(" %s", mazes[k][i]);
			for (int j = 0; j < m; j++) {
				if (mazes[k][i][j] == '1') 
					sx = i, sy = j, sz = k;
				else if (mazes[k][i][j] == '2')
					ex = i, ey = j, ez = k;
			}
		}
	}

	printf("%d\n", solve() * 5);
}
