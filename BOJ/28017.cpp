#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m;
int dp[502][502], times[505][505];


int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        int min_values[2] = { 5000002,5000002 };
        for (int j = 0; j < m; j++) {
            scanf("%d", &times[i][j]);

            dp[i][j] = times[i][j];
            if (i) {
                int prev_min_value = dp[i - 1][m];
                if (prev_min_value == dp[i - 1][j])
                    prev_min_value = dp[i - 1][m + 1];

                dp[i][j] += prev_min_value;
            }

            min_values[1] = min(min_values[1], dp[i][j]);
            sort(min_values, min_values + 2);
        }
        dp[i][m] = min_values[0];
        dp[i][m + 1] = min_values[1];
    }

    int ans = 99999999;
    for (int i = 0; i < m; i++)
        ans = min(ans, dp[n - 1][i]);

    printf("%d\n", ans);
}
