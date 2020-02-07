#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

string ans;
int n, m, k, dp[201][201], Q = 1000000000;

void nck() {
	for (int i = 0; i <= n + m; i++) {
		dp[i][0] = dp[i][i] = 1;
		for (int j = 1; j < i; j++)
			dp[i][j] = min(dp[i - 1][j] + dp[i - 1][j - 1], Q + 1);
	}
}

string solve(int x, int y, int chk) {
	if (!x) return string(y, 'z');
	if (chk <= dp[x + y - 1][y]) return "a" + solve(x - 1, y, chk);
	return "z" + solve(x, y - 1, chk - dp[x + y - 1][y]);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);

	nck();

	if (dp[n + m][m] < k) puts("-1");
	else cout << solve(n, m, k) << '\n';
}