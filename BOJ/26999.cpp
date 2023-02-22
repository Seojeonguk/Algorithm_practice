#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans;
char farms[1002][82];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve(int sx,int sy) {
	queue<pair<int, int>> q;
	q.push({ sx,sy });
	farms[sx][sy] = '.';
	int cnt = 0;
	
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		cnt++;

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + X[dir];
			int ny = y + Y[dir];

			if (isOut(nx, ny) || farms[nx][ny] != '*')
				continue;

			farms[nx][ny] = '.';
			q.push({ nx,ny });
		}
	}

	ans = max(ans, cnt);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &m, &n);

	for (int i = 0; i < n; i++)
		scanf(" %s", farms[i]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (farms[i][j] == '*')
				solve(i, j);

	printf("%d\n", ans);
}
