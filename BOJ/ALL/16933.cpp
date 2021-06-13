#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

struct  d {
    int x, y, wall_break, cnt;
    bool day_and_night;
};

int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int n, m, k,arr[1003][1003];
bool visit[1003][1003][13][3];
queue<d> q;

int solve() {
    visit[0][0][0][0] = true;
    q.push({ 0,0,0,1,0 });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.x == n - 1 && outdata.y == m - 1)
            return outdata.cnt;

        for (int i = 0; i < 4; i++) {
            int nx = outdata.x + X[i];
            int ny = outdata.y + Y[i];
            int nbreak = outdata.wall_break;
            bool nday_night = !outdata.day_and_night;

            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1) continue;

            if (arr[nx][ny] == 1) {
                if (!nday_night) continue;
                if (nbreak + 1 > k) continue;
                nbreak++;
            }
            if (!visit[nx][ny][nbreak][nday_night]) {
                visit[nx][ny][nbreak][nday_night] = true;
                q.push({ nx,ny,nbreak,outdata.cnt + 1,nday_night });
            }
            
        }

        if (!visit[outdata.x][outdata.y][outdata.wall_break][!outdata.day_and_night]) {
            visit[outdata.x][outdata.y][outdata.wall_break][!outdata.day_and_night] = true;
            q.push({ outdata.x,outdata.y,outdata.wall_break,outdata.cnt + 1,!outdata.day_and_night });
        }
    }

    return -1;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &k);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &arr[i][j]);

    printf("%d\n", solve());
}