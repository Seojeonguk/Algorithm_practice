#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
char farms[1001][1001];
int X[] = { 1,0 }, Y[] = { 0,1 };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>n - 1;
}

bool solve() {
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (x == n - 1 && y == n - 1)
			return true;

		for (int dir = 0; dir < 2; dir++) {
			int nx = x + X[dir];
			int ny = y + Y[dir];

			if (isOut(nx, ny) || farms[nx][ny] != '.')
				continue;

			farms[nx][ny] = 'x';
			q.push({ nx,ny });
		}
	}

	return false;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%s", farms[i]);

	puts(solve() ? "Yes" : "No");
}
