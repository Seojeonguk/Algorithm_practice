#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k;
char arr[1003][1003];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int sx, sy, dx, dy;
int visit[1003][1003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	memset(visit, -1, sizeof visit);
	for (int i = 0; i < n; i++) scanf(" %s", arr[i]);
	scanf("%d %d %d %d", &sx, &sy, &dx, &dy);
	sx--, sy--, dx--, dy--;
	queue<pair<int, int> > q;
	q.push({ sx,sy });
	visit[sx][sy] = 0;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		pair<int, int> indata;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= k; j++) {
				int nx = outdata.first + j * X[i], ny = outdata.second + j * Y[i];
				if (nx <0 || ny <0 || nx>n - 1 || ny > m - 1) break;
				if (arr[nx][ny] == '#') break;
				if (visit[nx][ny] == -1) {
					q.push({ nx,ny });
					visit[nx][ny] = visit[outdata.first][outdata.second] + 1;
				}
				else if (visit[nx][ny] < visit[outdata.first][outdata.second] + 1) break;
			}
		}
	}


	printf("%d\n", visit[dx][dy]);
}