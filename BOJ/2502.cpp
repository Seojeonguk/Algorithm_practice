#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int d, k, dp[32];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &d, &k);

	for (int i = 1; i <= k; i++) {
		for (int j = i; j <= k; j++) {
			memset(dp, 0, sizeof dp);
			dp[1] = i;
			dp[2] = j;
			
			for (int l = 3; l <= d; l++) {
				dp[l] = dp[l - 2] + dp[l - 1];
				if (dp[l] >= k) break;
			}
			if (dp[d] == k) {
				printf("%d\n%d\n", i, j);
				return 0;
			}
		}

	}
}