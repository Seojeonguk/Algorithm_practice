#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n,dp[80002];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int i = 3; i <= 80000; i++)
		dp[i] = dp[i - 1] + (i % 3 == 0 || i % 7 == 0 ? i : 0);

	while (t--) {
		scanf("%d", &n);
		printf("%d\n", dp[n]);
	}
}