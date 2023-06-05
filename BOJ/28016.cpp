#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans;
int drawing_plate[202][202];
double dp[202][202];
double max_p;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &drawing_plate[i][j]);
            if (drawing_plate[i][j] == 2) {
                dp[i][j] = 10000000.0l;
                drawing_plate[i][j] = 0;
            }
        }
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (drawing_plate[i][j] || drawing_plate[i-1][j]) continue;

            if (!drawing_plate[i - 1][j]) dp[i][j] = dp[i - 1][j];

            if (j > 0 && drawing_plate[i][j - 1] && !drawing_plate[i - 1][j - 1]) dp[i][j] += (dp[i - 1][j - 1]/2.0f);

            if (j < m && drawing_plate[i][j + 1] && !drawing_plate[i - 1][j + 1]) dp[i][j] += (dp[i - 1][j + 1]/2.0f);
        }
    }

    ans = -1;
    for (int i = 0; i < m; i++) {
        if (max_p < dp[n - 1][i]) {
            max_p = dp[n - 1][i];
            ans = i;
        }
    }

    printf("%d\n", ans);
}
