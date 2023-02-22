#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans[2];
char mazes[102][102];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve(int sx, int sy) {
	bool isFindEntrance = false;
	int cnt = 1;

	queue<pair<int, int>> q;
	q.push({ sx,sy });
	mazes[sx][sy] = 'X';

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + X[dir];
			int ny = y + Y[dir];

			if (isOut(nx, ny) || mazes[nx][ny] == 'X')
				continue;

			if ('A' <= mazes[nx][ny] && mazes[nx][ny] <= 'W') {
				isFindEntrance = true;
				continue;
			}
			if (mazes[nx][ny] == '.')
				cnt++;
			mazes[nx][ny] = 'X';
			q.push({ nx,ny });
		}
	}

	if (isFindEntrance) ans[0]++;
	else ans[1] += cnt;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	cin.ignore();
	for (int i = 0; i < n; i++)
		cin.getline(mazes[i], 102);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (mazes[i][j] == '.')
				solve(i, j);

	printf("%d %d\n", ans[0], ans[1]);
}
