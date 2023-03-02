#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, sx, sy, k;
int pixels[1002][1002];
bool visited[1002][1002];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(int x, int y) {
    return x<0 || y<0 || x>n - 1 || y>m - 1;
}

void solve() {
    queue<pair<int, int> > q;
    q.push({ sx,sy });
    visited[sx][sy] = true;

    int type = pixels[sx][sy];
    pixels[sx][sy] = k;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dir[i][0];
            int ny = cur.second + dir[i][1];

            if (isOut(nx, ny) || visited[nx][ny] || pixels[nx][ny] != type)
                continue;
            visited[nx][ny] = true;
            pixels[nx][ny] = k;
            q.push({ nx,ny });
        }
    }
}


int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &pixels[i][j]);

    scanf("%d %d %d", &sx, &sy, &k);

    solve();

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d", pixels[i][j]);
        }
        puts("");
    }
}
