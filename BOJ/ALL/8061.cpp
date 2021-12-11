#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
int cost[184][184],bitmap[184][184];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
queue < pair<int, int> > q;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(cost, -1, sizeof cost);
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &bitmap[i][j]);
            if (bitmap[i][j] == 1) {
                cost[i][j] = 0;
                q.push({ i,j });
            }
        }
    }

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = outdata.first + X[i];
            int ny = outdata.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || cost[nx][ny] != -1)
                continue;

            cost[nx][ny] = cost[outdata.first][outdata.second] + 1;
            q.push({ nx,ny });
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            printf("%d ", cost[i][j]);
        puts("");
    }
}