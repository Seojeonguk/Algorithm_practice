#include <iostream>
using namespace std;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 }, m[5][5], n = 4;
int ans[5][5];
bool chk;

void solve(int x, int y) {
	if (chk) return;
	if (x == n - 1 && y == n - 1) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				printf(" %d ", ans[i][j]);
			puts("");
		}

		chk = true;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nx = x + X[i];
		int ny = y + Y[i];
		if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1 || ans[nx][ny] || !m[nx][ny]) continue;
		ans[nx][ny] = 1;
		solve(nx, ny);

		ans[nx][ny] = 0;
	}
}

int main() {
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &m[i][j]);

	ans[0][0] = 1;

	solve(0, 0);
}