#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, b, w, r, c;
int boards[22][22];
bool isVisit[22][22];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
int score[2];

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>n - 1;
}

void solve(int sx, int sy) {
	queue<pair<int, int> > q;
	bool isFind[3] = { false, };
	q.push({ sx,sy });
	isVisit[sx][sy] = true;

	int cnt = 0;

	while (!q.empty()) {
		auto cur = q.front();
		q.pop();

		cnt++;

		for (int i = 0; i < 4; i++) {
			int nextX = cur.first + dir[i][0];
			int nextY = cur.second + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY])
				continue;

			if (boards[nextX][nextY]) {
				isFind[boards[nextX][nextY]] = true;
				continue;
			}
			isVisit[nextX][nextY] = true;
			q.push({ nextX,nextY });
		}
	}

	if (isFind[1] && !isFind[2]) score[0] += cnt;
	else if (!isFind[1] && isFind[2]) score[1] += cnt;
}


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &n)) {
		if (!n) break;
		memset(boards, 0, sizeof boards);
		memset(isVisit, false, sizeof isVisit);
		memset(score, 0, sizeof score);

		scanf("%d %d", &b, &w);

		for (int i = 0; i < b; i++) {
			scanf("%d %d", &r, &c);
			boards[r - 1][c - 1] = 1;
		}

		for (int i = 0; i < w; i++) {
			scanf("%d %d", &r, &c);
			boards[r - 1][c - 1] = 2;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (!boards[i][j] && !isVisit[i][j])
					solve(i, j);

		if (score[0] == score[1]) {
			puts("Draw");
			continue;
		}

		printf("%s wins by %d\n", score[0] > score[1] ? "Black" : "White", abs(score[0] - score[1]));
	}
}
