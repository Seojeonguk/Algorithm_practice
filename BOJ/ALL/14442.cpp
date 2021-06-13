#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

struct d {
    int x, y, wall ,cnt;
};
int n, m, k, arr[1002][1002];
bool visit[1002][1002][11];
int X[4] = { 1,0,-1,0 }, Y[4] = { 0,1,0,-1 };
queue<d> q;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &k);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &arr[i][j]);

    visit[0][0][0] = true;
    q.push({ 0,0,0,1 });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.x == n - 1 && outdata.y == m - 1) {
            printf("%d\n", outdata.cnt);
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = outdata.x + X[i];
            int ny = outdata.y + Y[i];
            int nwall = outdata.wall;

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1) continue;
            if (arr[nx][ny] == 1) nwall++;
            if (nwall > k || visit[nx][ny][nwall]) continue;
            visit[nx][ny][nwall] = true;
            q.push({ nx,ny,nwall,outdata.cnt+1 });
        }
    }
    puts("-1");
}