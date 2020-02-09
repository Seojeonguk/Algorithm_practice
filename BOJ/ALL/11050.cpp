#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int MOD = 10007;
int n, k, dp[1002][1002];

int solve(int x, int y) {
	if (!y || x == y) return 1;
	int&ret = dp[x][y];
	if (ret != -1) return ret;
	ret = 0;

	return ret = (solve(x - 1, y) + solve(x - 1, y - 1)) % MOD;

}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(dp, -1, sizeof dp);
	scanf("%d %d", &n, &k);

	printf("%d\n", solve(n, k));
}