#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char st[3], en[3];
bool isVisit[8][8];

int dir[8][2] = { {-2,-1},{-1,-2},{2,1},{1,2},{-1,2},{1,-2},{2,-1},{-2,1} };

bool isOut(int x, int y) {
	return x < 0 || y < 0 || x>7 || y>7;
}

int solve() {
	int sx = st[0] - 'a';
	int sy = st[1] - '1';

	int ex = en[0] - 'a';
	int ey = en[1] - '1';

	memset(isVisit, false, sizeof isVisit);

	queue<pair<int, pair<int, int> > > q;
	
	isVisit[sx][sy] = true;
	q.push({ 0,{sx,sy} });

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (x == ex && y == ey)
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
	while (scanf(" %s %s", st, en) != EOF) {
		printf("To get from %s to %s takes %d knight moves.\n",st,en,solve());
	}
}
