#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
char chk[503][503];
bool visit[503][503];
queue<pair<int, int> > q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf(" %s", &chk[i]);
		for (int j = 0; j < m; j++) {
			if (chk[i][j] == '.') chk[i][j] = 'D';
			else if (chk[i][j] == 'W') q.push({ i,j });
		}
	}

	bool sa = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (chk[outdata.first][outdata.second] == 'S') {
			puts("0");
			return 0;
		}

		for (int i = 0; i < 4; i++) {
			auto indata = outdata;
			indata.first += X[i];
			indata.second += Y[i];



			if (indata.first < 0 || indata.second < 0 || indata.first >= n || indata.second >= m || visit[indata.first][indata.second] || chk[indata.first][indata.second] == 'D') continue;
			visit[indata.first][indata.second] = true;
			q.push(indata);
		}
	}

	puts("1");
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) printf("%c", chk[i][j]);
		puts("");
	}
}