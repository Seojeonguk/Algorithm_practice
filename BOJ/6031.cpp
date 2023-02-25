#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans;
char pastures[752][752];
bool isVisit[752][752];
int dir[8][2] = { {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve(int sx, int sy) {
	int cnt = 0;
	queue<pair<int, int> > q;
	q.push({ sx,sy });
	isVisit[sx][sy] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		cnt++;

		for (int i = 0; i < 8; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || pastures[nextX][nextY] != '.')
				continue;
			isVisit[nextX][nextY] = true;
			q.push({ nextX,nextY });
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
		scanf(" %s", pastures[i]);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (pastures[i][j] == '.' && !isVisit[i][j]) {
				solve(i, j);
			}
		}
	}

	printf("%d\n", ans);
}
