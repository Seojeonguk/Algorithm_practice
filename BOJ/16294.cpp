#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int h, n, m, X[] = { -1,-1,1,1,0,0 }, Y[] = { -1,0,-1,0,-1,1 };
char honey[1004][1004];
bool visit[1004][1004];
priority_queue<int> pq;
int solve(int x, int y) {
	int cnt = 0;
	queue<pair<int, int> > q;
	q.push({ x,y });
	visit[x][y] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		cnt++;
		q.pop();

		for (int i = 0; i < 6; i++) {
			auto indata = outdata;
			indata.first += X[i];
			if (outdata.first % 2) indata.second += Y[i];
			else indata.second += (i < 4 ? abs(Y[i]) : Y[i]);
			if (indata.first < 0 || indata.second < 0 || honey[indata.first][indata.second] == '#' || visit[indata.first][indata.second]) continue;
			visit[indata.first][indata.second] = true;
			q.push(indata);
		}
	}
	return cnt;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(honey, '#', sizeof honey);
	scanf("%d %d %d", &h, &n, &m);
	for (int i = 0; i < n; i++) 
		for (int j = (i % 2 ? 1 : 0); j < (i % 2 ? m + 1 : m); j++) 
			scanf(" %c ", &honey[i][j]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j <= m; j++)
			if (honey[i][j] == '.' && !visit[i][j])
				pq.push(solve(i, j));

	int cnt = 0;
	while (h > 0) {
		cnt++;
		h -= pq.top();
		pq.pop();
	}
	printf("%d\n", cnt);
}