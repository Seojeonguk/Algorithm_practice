#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, m, k, ans, ans_cnt, from, to, cost;
int friends[102];
int dist[102][102];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    while (t--) {
        ans_cnt = 1e9;
        memset(dist, 0x3f, sizeof dist);
        scanf("%d %d", &n, &m);

        for (int i = 1; i <= n; i++)
            dist[i][i] = 0;

        for (int i = 0; i < m; i++) {
            scanf("%d %d %d", &from, &to, &cost);
            dist[from][to] = dist[to][from] = cost;
        }

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);

        scanf(" %d", &k);
        for (int i = 0; i < k; i++)
            scanf(" %d", &friends[i]);

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++)
                sum += dist[friends[j]][i];

            if (sum < ans_cnt) {
                ans_cnt = sum;
                ans = i;
            }
        }

        printf("%d\n", ans);
    }
}