#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, sx, sy;
bool visit[152][152];
char pasture[152][152];
int X[] = { -2,-1,1,2,2,1,-1,-2 }, Y[] = { 1,2,2,1,-1,-2,-2,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &m, &n);

    for (int i = 0; i < n; i++) {
        scanf(" %s", &pasture[i]);
        for (int j = 0; j < m; j++) {
            if (pasture[i][j] == 'K')
                sx = i, sy = j;
        }
    }

    queue<pair<int, pair<int, int> > > q;
    q.push({ 0,{sx,sy} });
    visit[sx][sy] = true;

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (pasture[outdata.second.first][outdata.second.second] == 'H') {
            printf("%d\n", outdata.first);
            return 0;
        }

        for (int i = 0; i < 8; i++) {
            int nx = outdata.second.first + X[i];
            int ny = outdata.second.second + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || pasture[nx][ny] == '*')
                continue;

            visit[nx][ny] = true;
            q.push({ outdata.first + 1,{nx,ny} });
        }
    }
}