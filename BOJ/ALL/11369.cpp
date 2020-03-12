#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int dp[52][52];
int n, p, q, j, k;
int solve(int now, int step) {
	if (now < 0 || now >= n) return 0;
	if (!step) return (p <= now && now <= q);
	int& ret = dp[now][step];
	if (ret!=-1) return ret;
	ret = 0;
	return ret = solve(now + 1, step - 1) + solve(now - 1, step - 1);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		memset(dp, -1, sizeof dp);
		scanf("%d %d %d %d %d", &n, &p, &q, &j, &k);
		if (n + p + q + j + k == 0) break;
		printf("%d\n", solve(j, k));
	}
}