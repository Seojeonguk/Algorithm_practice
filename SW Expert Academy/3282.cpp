#include<cstdio>
#include<cstring>
using namespace std;

int t;

int n, k, w, v;
int dp[1004];

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d", &n, &k);

        memset(dp, 0, sizeof dp);
        for (int i = 0; i < n; i++) {
            scanf("%d %d", &w, &v);

            for (int j = k; j >= w; j--) {
                if (dp[j] < v + dp[j - w])
                    dp[j] = v + dp[j - w];
            }
        }

        printf("#%d %d\n", tc, dp[k]);
    }
}
