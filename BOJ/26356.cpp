#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define pipii pair<int,pair<int,int> >
int t, n, r1, c1, r2, c2;
bool isVisit[22][22];
int dir[8][2] = { {-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2} };

bool isOut(int x, int y) {
	return x<1 || y<1 || x>n || y>n;
}

int solve() {
	memset(isVisit, false, sizeof isVisit);
	queue<pipii> q;
	q.push({ 0,{r1,c1} });

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (x == r2 && y == c2)
			return cnt;

		for (int i = 0; i < 8; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY]) continue;
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
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d %d %d %d", &n, &r1, &c1, &r2, &c2);

		printf("Case #%d: %d\n\n", tc, solve());
	}
}
