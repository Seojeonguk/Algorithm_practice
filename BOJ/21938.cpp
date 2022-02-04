#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, r, g, b, t;
int pixel[1002][1002];
bool visit[1002][1002];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d %d %d", &r, &g, &b);
			pixel[i][j] = (r + g + b) / 3;
		}
	}
	scanf("%d", &t);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			visit[i][j] = (pixel[i][j] < t ? false : true);

	int ans = 0;
	for(int i=0;i<n;i++)
		for (int j = 0; j < m; j++) {
			if (visit[i][j]) {
				queue<pair<int, int> > q;
				ans++;
				q.push({ i,j });
				visit[i][j] = false;
				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();

					for (int k = 0; k < 4; k++) {
						int nx = outdata.first + X[k];
						int ny = outdata.second + Y[k];

						if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || !visit[nx][ny]) continue;
						visit[nx][ny] = false;
						q.push({ nx,ny });
					}
				}
			}
		}

	printf("%d\n", ans);
}