#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;

int t;

char a[1002], b[1002];
int dp[1002][1002];

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf(" %s %s", a + 1, b + 1);

        int alength = strlen(a);
        int blength = strlen(b);

        
        int i, j;
        for (i = 1; a[i]; i++) {
            for (j = 1; b[j]; j++) {
                if (a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        printf("#%d %d\n", tc, dp[i-1][j-1]);
    }
}