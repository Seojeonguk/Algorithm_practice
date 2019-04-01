#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, arr[102][102];
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
struct d { int x, y, cnt; };
bool visit[102][102];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		for (int j = 0; j<m; j++)
			scanf("%1d", &arr[i][j]);

	queue<d> q;
	q.push({ 0,0,1 });
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.x == n - 1 && outdata.y == m - 1) {
			printf("%d\n", outdata.cnt);
			break;
		}

		for (int i = 0; i < 4; i++) {
			auto indata = outdata;
			indata.x += X[i], indata.y += Y[i], indata.cnt++;
			if (indata.x < 0 || indata.y < 0 || indata.x > n - 1 || indata.y > m - 1 || visit[indata.x][indata.y] || !arr[indata.x][indata.y]) continue;
			q.push(indata);
			visit[indata.x][indata.y] = true;
		}
	}
}