#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
int n, sa[101];
ll dp[102][21];

ll solve(int idx, int sum) {
	if (sum < 0 || sum > 20) return 0;
	if (idx == n - 1) return sum == sa[n - 1] ? 1 : 0;
	ll& ret = dp[idx][sum];
	if (ret != -1) return ret;
	ret = 0;
	ret += solve(idx + 1, sum + sa[idx]);
	ret += solve(idx + 1, sum - sa[idx]);

	return ret;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(dp, -1, sizeof dp);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &sa[i]);

	printf("%lld\n", solve(1, sa[0]));
}