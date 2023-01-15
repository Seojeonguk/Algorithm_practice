#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, c;
ll M[17][17];
int personalities[1002][2];
ll dp[1002][1002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    
    scanf("%d %d %d", &n, &m, &c);

    for (int i = 1; i <= c; i++)
        for (int j = 1; j <= c; j++)
            scanf("%lld", &M[i][j]);
    int idx = (n > m ? 1 : 0);
    for (int i = 0; i < n; i++)
        scanf("%d", &personalities[i][idx]);

    for (int i = 0; i < m; i++)
        scanf("%d", &personalities[i][(idx+1)%2]);

    ll ans = 0;
    for (int i = 0; i < min(n,m); i++) {
        ll prevMax = 0;
        for (int j = 0; j < max(n, m); j++) {
            dp[i][j] = prevMax + M[personalities[i][0]][personalities[j][1]];
            ans = max(ans, dp[i][j]);
            for (int k = 0; k < i; k++)
                prevMax = max(prevMax, dp[k][j]);
        }
    }

    printf("%lld\n", ans);
}
