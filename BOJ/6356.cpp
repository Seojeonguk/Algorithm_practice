#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
struct d {
	int x, y, dir,cnt;
}a;
char st[11];
int n, m,dx,dy;
int arr[52][52];
bool visit[52][52][4];
bool block[52][52];
int X[] = { -1,0,1,0 }, Y[] = { 0,-1,0,1 };

int solve() {
	queue<d> q;
	q.push(a);
	visit[a.x][a.y][a.dir] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		//printf("%d %d %d %d\n", outdata.x, outdata.y, outdata.dir, outdata.cnt);

		if (outdata.x == dx && outdata.y == dy) return outdata.cnt;

		outdata.cnt++;

		auto indata = outdata;
		indata.dir = (indata.dir + 1) % 4;
		if (!visit[indata.x][indata.y][indata.dir]) {
			visit[indata.x][indata.y][indata.dir] = true;
			q.push(indata);
		}

		indata = outdata;
		indata.dir = (indata.dir + 3) % 4;
		if (!visit[indata.x][indata.y][indata.dir]) {
			visit[indata.x][indata.y][indata.dir] = true;
			q.push(indata);
		}

		for (int i = 1; i < 4; i++) {
			indata = outdata;
			indata.x = indata.x + X[indata.dir] * i;
			indata.y = indata.y + Y[indata.dir] * i;

			if (visit[indata.x][indata.y][indata.dir]) continue;
			if (indata.x < 0 || indata.y < 0 || indata.x > n  || indata.y > m || block[indata.x][indata.y]) break;

			visit[indata.x][indata.y][indata.dir] = true;
			q.push(indata);
		}
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &n, &m);
		if (!n && !m) break;
		memset(visit, 0, sizeof visit);
		memset(block, 0, sizeof block);

		for (int i = 0; i <= n; i++)
			block[i][0] = block[i][m] = true;

		for (int i = 0; i <= m; i++)
			block[0][i] = block[n][i] = true;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				scanf("%d", &arr[i][j]);
				if (arr[i][j]) block[i][j] = block[i + 1][j] = block[i][j + 1] = block[i + 1][j + 1] = true;
			}

		

		scanf("%d %d %d %d %s", &a.x, &a.y, &dx, &dy, st);

		/*for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == a.x && j == a.y) printf("s ");
				else if (i == dx && j == dy) printf("d ");
				else printf("%d ", block[i][j]);
			}
			puts("");
		}*/

		if (st[0] == 'n') a.dir = 0;
		else if (st[0] == 'w') a.dir = 1;
		else if (st[0] == 's') a.dir = 2;
		else if (st[0] == 'e') a.dir = 3;

		a.cnt = 0;

		printf("%d\n", solve());
	}
}