#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int h, y, dp[11];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &h, &y);

    dp[0] = h;

    for (int i = 1; i <= y; i++) {
        dp[i] = (int)(1.05 * dp[i - 1]);
        if (i >= 3) dp[i] = max(dp[i], (int)(1.2 * dp[i - 3]));
        if (i >= 5) dp[i] = max(dp[i], (int)(1.35 * dp[i - 5]));
    }
    printf("%d\n", dp[y]);
}
