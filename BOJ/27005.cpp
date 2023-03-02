#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, sx, sy, ex, ey;
char maps[100][100];
int p[100][100];
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool isOut(int x, int y) {
    return x < 0 || y < 0 || x>2 * (n - 1) || y>2 * (m - 1);
}

void solve() {
    queue<pair<int, int> > q;
    q.push({ sx,sy });
    p[sx][sy] = 0;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nextX = cur.first + dir[i][0];
            int nextY = cur.second + dir[i][1];

            if (isOut(nextX, nextY) || maps[nextX][nextY] == '.') continue;
            nextX += dir[i][0];
            nextY += dir[i][1];

            if (p[nextX][nextY] != -1) continue;
            p[nextX][nextY] = (i + 2) % 4;
            q.push({ nextX,nextY });
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    memset(p, -1, sizeof p);
    scanf("%d %d", &n, &m);

    for (int i = 0; i < 2 * n - 1; i++) {
        scanf(" %s", maps[i]);
        for (int j = 0; j < 2 * m - 1; j++) {
            if (maps[i][j] == 'S') sx = i, sy = j;
            else if (maps[i][j] == 'E') ex = i, ey = j;
        }
    }

    solve();

    stack<pair<char, int> > s;
    while (sx != ex || sy != ey) {
        char c = 0;
        if (p[ex][ey] == 0) c = 'S';
        else if (p[ex][ey] == 1) c = 'E';
        else if (p[ex][ey] == 2) c = 'N';
        else if (p[ex][ey] == 3) c = 'W';

        if (s.empty() || s.top().first != c) {
            s.push({ c,1 });
        }
        else {
            auto t = s.top();
            s.pop();
            t.second++;
            s.push(t);
        }
        int nextX = ex + 2 * dir[p[ex][ey]][0];
        int nextY = ey + 2 * dir[p[ex][ey]][1];

        ex = nextX;
        ey = nextY;
    }

    while (!s.empty()) {
        printf("%c %d\n", s.top().first, s.top().second);
        s.pop();
    }
}
