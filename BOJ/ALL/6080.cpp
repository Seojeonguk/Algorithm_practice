#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int X[] = { 1,1,1,0,0,-1,-1,-1 }, Y[] = { -1,0,1,-1,1,-1,0,1 };
int ans, n, m, bessie[1003][1003];
bool visit[1003][1003];

int solve(int x, int y) {
	queue<pair<int, int> > q;
	visit[x][y] = true;
	q.push({ x,y });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (int i = 0; i < 8; i++) {
			int nx = outdata.first + X[i], ny = outdata.second + Y[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || !bessie[nx][ny]) continue;
			visit[nx][ny] = true;
			q.push({ nx,ny });
		}
	}
	return 1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) scanf("%d", &bessie[i][j]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (bessie[i][j] && !visit[i][j])
				ans += solve(i, j);

	printf("%d\n", ans);
}