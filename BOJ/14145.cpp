#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, num;
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
int fields[52][52], isVisit[52][52], ranking[11];
priority_queue<pair<int, int> > pq;

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve(int sx,int sy) {
	queue<pair<int, int> > q;
	int cnt = 0;
	q.push({ sx,sy });
	isVisit[sx][sy] = ++num;
	
	while (!q.empty()) {
		auto cur = q.front();
		q.pop();

		cnt++;

		for (int i = 0; i < 4; i++) {
			int nextX = cur.first + dir[i][0];
			int nextY = cur.second + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || !fields[nextX][nextY])
				continue;

			isVisit[nextX][nextY] = num;
			q.push({ nextX,nextY });
		}
	}
	pq.push({ cnt,num });
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			scanf("%1d", &fields[i][j]);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (fields[i][j] == 1 && !isVisit[i][j])
				solve(i, j);
		}
	}

	while (!pq.empty()) {
		auto cur = pq.top();
		ranking[cur.second] = pq.size();
		pq.pop();
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d", fields[i][j] ? ranking[isVisit[i][j]] : 0);
		}
		puts("");
	}
}
