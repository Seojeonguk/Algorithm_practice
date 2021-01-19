#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, k, arr[20][20];

int solve(int x, int y) {
	int garo = 0;
	int sero = 0;

	int now_x = x-1, now_y = y;
	while (arr[now_x--][now_y] == 1) {
		garo++;
	}

	now_x = x +1, now_y = y;
	while (arr[now_x++][now_y] == 1) {
		garo++;
	}

	now_x = x, now_y = y-1;
	while (arr[now_x][now_y--] == 1) {
		sero++;
	}

	now_x = x, now_y = y+1;
	while (arr[now_x][now_y++] == 1) {
		sero++;
	}
	

	return (garo + 1 == k ? 1 : 0) + (sero + 1 == k ? 1 : 0);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &k);

		memset(arr, 0, sizeof arr);

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				scanf("%d", &arr[i][j]);

		int ans = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (arr[i][j] == 1)
					ans += solve(i, j);

		printf("#%d %d\n", tc, ans/k);
	}
}