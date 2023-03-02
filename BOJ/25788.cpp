#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;


int n, total_type_score, total_color_score;
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

bool visit[28][28][2];
char types[28][28];
int colors[28][28];
int types_score[27];
int color_score[27];

bool isOut(int x, int y) {
    return x<0 || y<0 || x>n - 1 || y>n - 1;
}

int match_type(int sx, int sy) {
    int ret = 0;
    queue<pair<int, int> > q;
    q.push({ sx,sy });
    visit[sx][sy][1] = true;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dir[i][0];
            int ny = cur.second + dir[i][1];

            if (isOut(nx, ny) || visit[nx][ny][1] || types[nx][ny] != types[sx][sy]) continue;
            visit[nx][ny][1] = true;
            q.push({ nx,ny });
            ret++;
        }
    }

    return ret;
}

int match_color(int sx, int sy) {
    int ret = 0;
    queue<pair<int, int> > q;
    q.push({ sx,sy });
    visit[sx][sy][0] = true;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dir[i][0];
            int ny = cur.second + dir[i][1];

            if (isOut(nx, ny) || visit[nx][ny][0] || colors[nx][ny] != colors[sx][sy]) continue;
            visit[nx][ny][0] = true;
            q.push({ nx,ny });
            ret++;
        }
    }

    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf(" %c %d", &types[i][j], &colors[i][j]);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!visit[i][j][1]) {
                int cnt = match_type(i, j);
                int score = (cnt * (cnt + 1)) / 2;
                int idx = types[i][j] - 'A';
                types_score[idx] = max(types_score[idx], score);
            }
            if (!visit[i][j][0]) {
                int cnt = match_color(i, j);
                int score = (cnt * (cnt + 1)) / 2;
                int idx = colors[i][j];
                color_score[idx] = max(color_score[idx], score);
            }
        }
    }

    for (int i = 0; i < 27; i++) {
        total_type_score += types_score[i];
        total_color_score += color_score[i];
    }

    printf("%d %d\n", total_type_score, total_color_score);
}
