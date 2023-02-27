#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, m;
char boxs[1001][1001];
int dir[4][2] = { {-1,0},{1,0},{0,-1},{0,1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int solve(int sx, int sy) {
	int ret = 0;
	boxs[sx][sy] = '#';
	queue<pair<int, int> > q;
	q.push({ sx,sy });

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		ret++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || boxs[nextX][nextY] == '#')
				continue;
			
			boxs[nextX][nextY] = '#';
			q.push({ nextX,nextY });
		}
	}

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d", &n, &m);

		for (int i = 0; i < n; i++)
			scanf("%s", boxs[i]);

		int section_cnt = 0;
		int space_cnt = 0;
		for (int i = 0; i < n; i++) {
			for(int j=0;j<m;j++)
				if (boxs[i][j] == '.') {
					section_cnt++;
					space_cnt += solve(i, j);
				}
		}
		printf("%d section%s, %d space%s\n", section_cnt, section_cnt == 1 ? "" : "s", space_cnt, space_cnt == 1 ? "" : "s");
	}
}
