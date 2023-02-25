#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int ex, ey, n, x, y;
bool isVisit[1010][1010];
bool isPool[1010][1010];

int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(int x, int y) {
	return x < 0 || y < 0 || x>1000 || y>1000;
}

int solve() {
	queue<pair<int,pair<int, int> > > q;
	q.push({ 0,{500,500} });
	isVisit[500][500] = true;

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (x == ex && y == ey) {
			return cnt;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || isPool[nextX][nextY])
				continue;
			isVisit[nextX][nextY] = true;
			q.push({ cnt + 1,{nextX,nextY} });
		}
	}

	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &ex, &ey, &n);

	ex += 500, ey += 500;

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		x += 500, y += 500;
		isPool[x][y] = true;
	}

	printf("%d\n", solve());
}
