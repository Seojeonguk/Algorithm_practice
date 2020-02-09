#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, sx, sy,x,y, dp[502][502], X[] = { -2,-2,-1,-1,1,1,2,2 }, Y[] = { -1,1,-2,2,-2,2,-1,1 };
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(dp, -1, sizeof dp);
	scanf("%d %d %d %d", &n, &m,&sx,&sy);
	queue<pair<int, int> > q;
	dp[--sx][--sy] = 0;
	q.push({ sx,sy });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (int i = 0; i < 8; i++) {
			int nx = outdata.first + X[i], ny = outdata.second + Y[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || dp[nx][ny] != -1) continue;
			dp[nx][ny] = dp[outdata.first][outdata.second] + 1;
			q.push({ nx,ny });
		}
	}
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		printf("%d ", dp[x - 1][y - 1]);
	}
}