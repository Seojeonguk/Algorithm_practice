#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;


deque<pair<int, int> > dq;
bool isVisit[1002][1002];
int n, m, r, dir;
char q;
char maps[1002][1002];

int xy[4][2] = { {-1,0},{0,1},{1,0},{0,-1} };

int charToInt(char c) {
	if (c == 'N') return 0;
	if (c == 'E') return 1;
	if (c == 'S') return 2;
	if (c == 'W') return 3;
}

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %c", &n, &m, &r, &q);

	for (int i = 0; i < n; i++) {
		scanf(" %s", maps[i]);
		for (int j = 0; j < m; j++) {
			if (maps[i][j] == 'W') {
				dq.push_back({ i,j });
				isVisit[i][j] = true;
			}
		}
	}
	dir = charToInt(q);

	int i = 0;
	for (i = 0; i < r; i++) {
		scanf(" %c ", &q);
		if (q == 'L') dir = (dir + 3) % 4;
		else if (q == 'P') dir = (dir + 1) % 4;

		int nextX = dq[0].first + xy[dir][0];
		int nextY = dq[0].second + xy[dir][1];

		if (isOut(nextX, nextY) || isVisit[nextX][nextY]) break;

		dq.push_front({ nextX,nextY });
		isVisit[nextX][nextY] = true;
		if (maps[nextX][nextY] == 'J') {
			maps[nextX][nextY] = '.';
		}
		else {
			isVisit[dq.back().first][dq.back().second] = false;
			dq.pop_back();
		}
	}

	if (i == r) printf("OK");
	else printf("%d\n", i + 1);
}
