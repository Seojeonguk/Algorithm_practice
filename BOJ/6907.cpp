#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int flooring;
int n, m;
char grid[27][27];
priority_queue<int> pq;

int dir[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve(int sx, int sy) {
	int cnt = 0;
	queue<pair<int, int> > q;
	q.push({ sx,sy });
	grid[sx][sy] = 'I';

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		cnt++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || grid[nextX][nextY] != '.')
				continue;
			grid[nextX][nextY] = 'I';
			q.push({ nextX,nextY });
		}
	}
	pq.push(cnt);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &flooring, &n, &m);
	
	for (int i = 0; i < n; i++)
		scanf(" %s", grid[i]);

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++) 
			if (grid[i][j] == '.')
				solve(i, j);

	int ans = 0;
	while (!pq.empty()) {
		int largets_room_size = pq.top();
		pq.pop();

		if (flooring < largets_room_size)
			break;
		flooring -= largets_room_size;
		ans++;
	}

	printf("%d %s, %d square metre(s) left over", ans, ans == 1 ? "room" : "rooms", flooring);
}
