#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, sx, sy;
char tiles[51][51];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

bool isOut(int x, int y) {
	return (x<0 || y<0 || x>n - 1 || y>m - 1);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d %d", &m, &n)) {
		if (!n || !m) break;
		for (int i = 0; i < n; i++) {
			scanf(" %s", tiles[i]);
			for (int j = 0; j < m; j++)
				if (tiles[i][j] == 'A') {
					sx = i, sy = j;
					tiles[i][j] = '#';
				}
		}

		int ans = 1;
		queue<pair<int, int> > q;
		q.push({ sx,sy });

		while (!q.empty()) {
			pair<int, int> now = q.front();
			q.pop();

			for (int i = 0; i < 4; i++) {
				int nx = now.first + X[i];
				int ny = now.second + Y[i];

				if (isOut(nx, ny) || tiles[nx][ny] == '#')
					continue;

				tiles[nx][ny] = '#';
				ans++;
				q.push({ nx,ny });
			}
		}

		printf("%d\n", ans);
	}
}
