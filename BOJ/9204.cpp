#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;

char sx, ex;
int sy, ey;
int isVisit[8][8];
int dir[4][2] = { {-1,-1},{-1,1},{1,-1},{1,1} };

bool isOut(int x, int y) {
	return x < 0 || y < 0 || x>7 || y>7;
}

void solve() {
	memset(isVisit, -1, sizeof isVisit);
	queue<pair<int, int> > q;
	q.push({ sx,sy });

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];
			while (!isOut(nextX, nextY)) {
				if (isVisit[nextX][nextY] == -1) {
					isVisit[nextX][nextY] = x * 10 + y;
					q.push({ nextX ,nextY });
				}
				nextX += dir[i][0];
				nextY += dir[i][1];
			}
		}
	}

	isVisit[sx][sy] = -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf(" %c %d %c %d", &sx, &sy, &ex, &ey);
		sx -= 'A', ex -= 'A';
		sy--, ey--;

		int diff_x = abs((sx % 2) - (ex % 2));
		int diff_y = abs((sy % 2) - (ey % 2));

		if ((diff_x + diff_y) % 2) {
			puts("Impossible");
			continue;
		}

		solve();
		stack<int> s;
		s.push(ex * 10 + ey);
		while (isVisit[ex][ey] != -1) {
			int tmp = isVisit[ex][ey];
			s.push(tmp);
			ex = tmp / 10;
			ey = tmp % 10;
		}

		printf("%zd", s.size() - 1);
		while (!s.empty()) {
			printf(" %c %d", 'A' + s.top() / 10, 1 + s.top() % 10);
			s.pop();
		}
		puts("");
	}
}
