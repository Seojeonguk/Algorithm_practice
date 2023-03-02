#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, m, ex, ey;
int buildings[11][11];
bool visited[11][11];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(int x, int y) {
    return x<1 || y<1 || x>n || y>m;
}

int solve(int sx, int sy) {
    int ret = 0;
    memset(visited, false, sizeof visited);

    queue<pair<int, int> > q;
    q.push({ sx,sy });
    visited[sx][sy] = true;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        if (cur.first == 1 || cur.second == 1 || cur.first == n || cur.second == m)
            ret++;

        for (int i = 0; i < 4; i++) {
            int nextX = cur.first + dir[i][0];
            int nextY = cur.second + dir[i][1];

            if (isOut(nextX, nextY) || visited[nextX][nextY])
                continue;

            if (buildings[cur.first][cur.second] > buildings[nextX][nextY])
                continue;

            visited[nextX][nextY] = true;
            q.push({ nextX,nextY });
        }
    }
    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d", &n, &m);
        scanf("%d %d", &ex, &ey);

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                scanf("%d", &buildings[i][j]);

        printf("Case #%d: %d\n", tc, solve(ex,ey));
    }
}
