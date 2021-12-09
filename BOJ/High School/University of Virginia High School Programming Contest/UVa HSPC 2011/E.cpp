#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int solve();
int t, n, m;
char mazes[16][16];
bool visit[16][16];
pair<int, int> start;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int tc = 0; tc < t; tc++) {
        memset(mazes, 0, sizeof mazes);
        memset(visit, 0, sizeof visit);

        scanf("%d %d", &n, &m);

        for (int i = 0; i < n; i++) {
            scanf(" %s", &mazes[i]);
            for (int j = 0; j < m; j++)
                if (mazes[i][j] == 'S')
                    start.first = i, start.second = j;
        }

        int path_length = solve();

        if (path_length == -1) puts("No Exit");
        else printf("Shortest Path: %d\n", path_length);
    }
}

int solve() {
    queue<pair<int, pair<int, int> > > q;
    q.push({ 0,start });
    visit[start.first][start.second] = true;

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        int x = outdata.second.first;
        int y = outdata.second.second;

        if (mazes[x][y] == 'G')
            return outdata.first;

        for (int i = 0; i < 4; i++) {
            int nx = x + X[i];
            int ny = y + Y[i];

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || mazes[nx][ny] == 'X')
                continue;

            visit[nx][ny] = true;
            q.push({ outdata.first + 1,{nx,ny} });
        }
    }
    return -1;
}