#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
int arr[100001];
int dp[100001][2];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    dp[0][0] = dp[0][1] = arr[0];
    int ans = arr[0];

    for (int i = 1; i < n; i++) {
        dp[i][0] = max(dp[i - 1][0] + arr[i], arr[i]);
        dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
        ans = max(ans, max(dp[i][0], dp[i][1]));
    }

    printf("%d\n", ans);
}
