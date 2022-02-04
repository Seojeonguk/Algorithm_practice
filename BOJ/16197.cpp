#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, X[4] = { -1,0,1,0 }, Y[4] = { 0,1,0,-1 };
char board[23][23];
char arr[23];
bool visit[23][23][23][23];


struct qwe {
	int cnt,a,b,c,d;

	bool operator<(const qwe& data) const { return cnt > data.cnt; }
	bool operator>(const qwe& data) const { return cnt < data.cnt; }
};
priority_queue <qwe> q;

int chk_(int x, int y) {
	if (x == 0 || y == 0 || x == n+1 || y == m+1) return 1;
	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	pair<int, int> x, y;
	x = { -1,-1 };
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		scanf(" %s", arr);
		for (int j = 1; j <= m; j++) {
			board[i][j] = arr[j - 1];
			if (board[i][j] == 'o') {
				if (x.first != -1) y = { i,j };
				else x = { i,j };
			}
		}
	}

	q.push({ 0,x.first,x.second,y.first,y.second });
	visit[x.first][x.second][y.first][y.second] = true;

	while (!q.empty()) {
		auto y = q.top();
		q.pop();

		int chk = chk_(y.a, y.b) + chk_(y.c, y.d);
		if (chk == 1) {
			printf("%d\n", y.cnt);
			return 0;
		}
		else if (chk == 2) continue;
		if (y.cnt == 10)continue;

		for (int i = 0; i < 4; i++) {
			auto aa = y;
			aa.a += X[i], aa.b += Y[i], aa.c += X[i], aa.d += Y[i];
			if (board[aa.a][aa.b] == '#') aa.a -= X[i], aa.b -= Y[i];
			if (board[aa.c][aa.d] == '#') aa.c -= X[i], aa.d -= Y[i];
			if (aa.a == aa.c && aa.b == aa.d) continue;
			if (visit[aa.a][aa.b][aa.c][aa.d]) continue;
			visit[aa.a][aa.b][aa.c][aa.d] = true;
			q.push({ aa.cnt + 1,aa.a,aa.b,aa.c,aa.d });
		}
	}
	printf("-1");
}