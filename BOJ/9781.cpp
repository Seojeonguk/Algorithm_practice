#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
struct state {
	int x, y, cnt;
};

int n, m, sx, sy, ex, ey;
bool isVisit[102][102];
char metros[102][102];
int dir[8][2] = { {1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int solve() {
	queue<state> q;
	isVisit[sx][sy] = true;
	q.push({ sx,sy,0 });

	while (!q.empty()) {
		state cur = q.front();
		q.pop();

		if (cur.x == ex && cur.y == ey)
			return cur.cnt;

		for (int i = 0; i < 8; i++) {
			state next = { cur.x + dir[i][0], cur.y + dir[i][1] , cur.cnt + 1 };
			if (isOut(next.x, next.y) || isVisit[next.x][next.y] || metros[next.x][next.y] == '#')
				continue;
			isVisit[next.x][next.y] = true;
			q.push(next);
		}
	}

	return -1;
}
 
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf(" %s", metros[i]);
		for (int j = 0; j < m; j++) {
			if (metros[i][j] == 'K')
				sx = i, sy = j;
			else if (metros[i][j] == 'X')
				ex = i, ey = j;
		}
	}

	printf("%d\n", solve());
}
