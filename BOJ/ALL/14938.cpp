#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, r,from,to,cost,ans;
int item_cnt[103];
int dist[103][103];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &r);

    memset(dist, 0x3f, sizeof dist);
    for (int i = 0; i < n; i++) {
        dist[i][i] = 0;
        scanf("%d", &item_cnt[i]);
    }

    for (int i = 0; i < r; i++) {
        scanf("%d %d %d", &from, &to, &cost);
        from--, to--;
        dist[from][to] = dist[to][from] = cost;
    }

    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (dist[i][j] <= m)
                sum += item_cnt[j];
        }
        ans = max(ans, sum);
    }

    printf("%d\n", ans);
}