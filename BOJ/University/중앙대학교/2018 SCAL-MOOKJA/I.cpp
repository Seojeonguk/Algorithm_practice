#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int game[4][4];
bool visit[4][4];
int X[] = { 0,1 }, Y[] = { 1,0 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &game[i][j]);

    queue<pair<int, int> > q;
    q.push({ 0,0 });
    visit[0][0] = true;

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        if (outdata.first == n - 1 && outdata.second == n - 1) {
            puts("HaruHaru");
            return 0;
        }

        for (int i = 0; i < 2; i++) {
            int nx = outdata.first + X[i] * game[outdata.first][outdata.second];
            int ny = outdata.second + Y[i] * game[outdata.first][outdata.second];

            if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1 || visit[nx][ny])
                continue;

            q.push({ nx,ny });
            visit[nx][ny] = true;
        }
    }
    puts("Hing");
}