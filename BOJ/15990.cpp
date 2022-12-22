#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
ll dp[100002][4];
#define MOD 1000000009

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    dp[1][1] = dp[2][2] = dp[3][3] = 1;
    for (int i = 3; i <= 100000; i++) {
        dp[i][1] += (dp[i - 1][2] + dp[i - 1][3] % MOD);
        dp[i][2] += (dp[i - 2][1] + dp[i - 2][3] % MOD);
        dp[i][3] += (dp[i - 3][1] + dp[i - 3][2] % MOD);
    }
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        printf("%lld\n", (dp[n][1] + dp[n][2] + dp[n][3]) % MOD);
    }
}