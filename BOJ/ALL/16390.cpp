#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, X[] = { -1,-1,-1,0,0,1,1,1 }, Y[] = { -1,0,1,1,-1,-1,0,1 };
char sa[103][103];
bool visit[103][103];
int solve(int x, int y) {
	queue<pair<int, int> > q;
	visit[x][y] = true;
	q.push({ x,y });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (int i = 0; i < 8; i++) {
			auto indata = outdata;
			indata.first += X[i], indata.second += Y[i];
			if (indata.first < 0 || indata.second < 0 || indata.first >= n || indata.second >= m || visit[indata.first][indata.second] || sa[indata.first][indata.second] == '.') continue;
			visit[indata.first][indata.second] = true;
			q.push(indata);
		}
	}

	return 1;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) scanf("%s", sa[i]);

	int cnt = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (!visit[i][j] && sa[i][j] == '#')
				cnt += solve(i,j);

	printf("%d\n", cnt);
}