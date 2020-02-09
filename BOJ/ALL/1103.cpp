#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 }, ans;
char b[52][52];
int dp[52][52];
int solve(int x, int y) {
	if (x < 0 || y < 0 || x >= n || y >= m || b[x][y] == 'H') return 0;
	int&ret = dp[x][y];
	if (ret) {
		if (ret == -1) {
			puts("-1");
			exit(0);
		}
		return ret;
	}

	ret = -1;
	int tmp = 0;

	for (int i = 0; i < 4; i++)
		tmp = max(tmp, solve(x + X[i] * (b[x][y] - '0'), y + Y[i] * (b[x][y] - '0')) + 1);

	return ret = tmp;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) scanf(" %s", b[i]);

	printf("%d\n", solve(0, 0));
}