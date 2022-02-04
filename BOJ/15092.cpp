#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, ans;
char petri[103][103];
int X[] = { -1,-1,-1,0,0,1,1,1 }, Y[] = { -1,0,1,1,-1,-1,0,1 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		scanf(" %s", petri[i]);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (petri[i][j] == '#') {
				ans++;

				queue<pair<int, int> > q;
				q.push({ i,j });

				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();

					for (int i = 0; i < 8; i++) {
						int nx = outdata.first + X[i];
						int ny = outdata.second + Y[i];

						if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || petri[nx][ny] != '#') continue;
						petri[nx][ny] = '.';
						q.push({ nx,ny });
					}
				}
			}
		}
	}

	printf("%d\n", ans);
}