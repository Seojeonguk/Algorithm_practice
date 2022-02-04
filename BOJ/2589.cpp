#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, ans;
struct d {
	int x, y, cnt;
};
queue<d> q;
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
char arr[52][52];
bool visit[52][52];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf(" %s", &arr[i]);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 'L') {
				memset(visit, false, sizeof visit);
				q.push({ i,j,0 });
				visit[i][j] = true;

				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();

					ans = max(ans, outdata.cnt);

					for (int i = 0; i < 4; i++) {
						int nx = outdata.x + X[i], ny = outdata.y + Y[i];
						if (nx < 0 || ny<0 || nx> n - 1 || ny> m - 1 || visit[nx][ny] || arr[nx][ny] == 'W') continue;
						q.push({ nx,ny,outdata.cnt + 1 });
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
	printf("%d\n", ans);
}