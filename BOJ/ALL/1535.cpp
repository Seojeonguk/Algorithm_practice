#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, dp[101], a[22], b[22];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    for (int i = 1; i <= n; i++) scanf("%d", &b[i]);

    for (int i = 1; i <= n; i++) {
        for (int j = 100; j > a[i]; j--)
            dp[j] = max(dp[j], dp[j - a[i]] + b[i]);
    }

    printf("%d\n", dp[100]);
}