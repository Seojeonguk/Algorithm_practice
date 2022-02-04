#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int h, w, n, s[1002][1002], dp[1002][1002];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &h, &w, &n);

	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
			scanf("%d", &s[i][j]);

	dp[0][0] = n - 1;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			dp[i][j + 1] += s[i][j] % 2 ? (dp[i][j] + 1) / 2 : dp[i][j] / 2;
			dp[i + 1][j] += s[i][j] % 2 ? dp[i][j] / 2 : (dp[i][j] + 1) / 2;
		}
	}

	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
			s[i][j] = (s[i][j] + dp[i][j]) & 1;

	int nx = 0, ny = 0;
	while (nx != h && ny != w) {
		if (s[nx][ny]) ny++;
		else nx++;
	}
	printf("%d %d\n", nx + 1, ny + 1);
}