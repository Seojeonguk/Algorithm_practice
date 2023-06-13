#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, k;
int acc[2002][2002];
char chess[2002][2002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &k);

    for (int i = 1; i <= n; i++) {
        scanf(" %s", chess[i] + 1);

        for (int j = 1; j <= m; j++) {
            if (((i + j) % 2 == 0 && chess[i][j] != 'B') || ((i + j) % 2 != 0 && chess[i][j] == 'B'))
                acc[i][j] = 1;

            acc[i][j] += acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
        }
    }

    int ans = 9999999;

    for (int i = k; i <= n; i++) {
        for (int j = k; j <= m; j++) {
            int cnt = acc[i][j] - acc[i - k][j] - acc[i][j - k] + acc[i - k][j - k];
            int Rcnt = k * k - cnt;

            ans = min(ans, min(cnt, Rcnt));
        }
    }

    printf("%d\n", ans);
}