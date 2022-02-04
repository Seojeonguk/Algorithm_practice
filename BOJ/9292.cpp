#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, m, sx, sy, dx, dy, d, X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
bool visit[23][23][5];
char room[23][23];

int solve() {
	int now = m, ret = 0;
	while (now!=-1) {
		if (sx == dx && sy == dy) return ret;
		if (visit[sx][sy][d]) return -1;

		if (room[sx + 1][sy] == 'p' || room[sx - 1][sy] == 'p' || room[sx][sy + 1] == 'p' || room[sx][sy - 1] == 'p')
			if (now <= m / 2) {
				ret += m - now;
				now = m;
			}
		visit[sx][sy][d] = true;
		now--;
		int nx = sx + X[d], ny = sy + Y[d];
		if (room[nx][ny] == 'p' || room[nx][ny] == 'x') d = (d + 1) % 4;
		else sx = nx, sy = ny;
		
		ret++;
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int tc = 1; tc <= t; tc++) {
		memset(visit, 0, sizeof visit);
		d = 0;
		scanf("%d %d", &n, &m);
		for (int i = 0; i < n; i++) {
			scanf("%s", room[i]);
			for (int j = 0; j < n; j++) {
				if (room[i][j] == 'r') sx = i, sy = j, room[i][j] = '-';
				if (room[i][j] == 'm') dx = i, dy = j, room[i][j] = '-';
			}
		}
		int ans = solve();
		printf("Case %d: ", tc);
		if (ans != -1) printf("%d\n", ans);
		else puts("NEVER");
	}
}