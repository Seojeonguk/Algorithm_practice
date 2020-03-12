#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)

int n, m;
char arr[10001][10001];
bool chk[10001][10001];
const int X[] = { 0,1,0,-1 };
const int Y[] = { 1,0,-1,0 };

bool range(int x, int y) {
	if (x<0 || y<0 || x>n - 1 || y>m - 1)
		return false;
	return true;
}

void solve(int x, int y) {
	chk[x][y] = true;

	queue<pair<int, int> > q;
	q.push({ x,y });
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			auto indata = outdata;
			indata.first += X[i];
			indata.second += Y[i];
			if (!range(indata.first, indata.second))
				continue;

			if (arr[indata.first][indata.second] == 'T') {
				chk[indata.first][indata.second] = true;
				arr[indata.first][indata.second] = 'S';
				q.push(indata);
			}
		}
	}
}

using namespace std;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &m, &n);
		if (m + n == 0)
			break;
		memset(chk, false, sizeof chk);
		for (int i = 0; i < n; i++)
			scanf("%s", arr[i]);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (arr[i][j] == 'S' && !chk[i][j])
					solve(i, j);

		for (int i = 0; i < n; i++)
			printf("%s\n", arr[i]);
	}
}