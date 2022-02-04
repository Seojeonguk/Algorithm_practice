#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, sx, sy;
bool visit[3002][3002];
queue < pair<int, pair<int, int> > > q;
char info[3002][3002];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        scanf(" %s", info[i]);
        for (int j = 0; j < m; j++) 
            if (info[i][j] == '2')
                sx = i, sy = j, info[i][j] = '0';
    }

    q.push({ 0,{sx,sy} });
    visit[sx][sy] = true;

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (info[outdata.second.first][outdata.second.second] != '0') {
            puts("TAK");
            printf("%d\n", outdata.first);
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = outdata.second.first + X[i];
            int ny = outdata.second.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || info[nx][ny] == '1') continue;
            visit[nx][ny] = true;
            q.push({ outdata.first + 1,{nx,ny} });
        }
    }
    puts("NIE");
}