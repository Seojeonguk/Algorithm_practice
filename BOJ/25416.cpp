#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int boards[5][5], sx, sy;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
bool isVisit[5][5];

int solve() {
	queue<pair<int, pair<int, int>>> q;

	q.push({ 0,{sx,sy} });
	isVisit[sx][sy] = true;

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (boards[x][y] == 1)
			return cnt;

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + X[dir];
			int ny = y + Y[dir];

			if (nx < 0 || ny < 0 || nx>4 || ny>4 || isVisit[nx][ny] || boards[nx][ny] == -1)
				continue;
			
			isVisit[nx][ny] = true;
			q.push({ cnt + 1,{nx,ny} });
		}
	}
	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 5; j++)
			scanf("%d", &boards[i][j]);

	scanf("%d %d", &sx, &sy);

	printf("%d\n", solve());
}
