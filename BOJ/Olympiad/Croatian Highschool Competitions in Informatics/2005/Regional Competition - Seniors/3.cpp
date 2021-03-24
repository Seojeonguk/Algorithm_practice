#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
char arr[255][255];
bool visit[255][255];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int v, k;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf(" %s", arr[i]);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] != '#' && !visit[i][j]) {
                int v_cnt = 0, k_cnt = 0;
                queue<pair<int, int> > q;
                visit[i][j] = true;
                q.push({ i,j });
                while (!q.empty()) {
                    auto outdata = q.front();
                    q.pop();

                    if (arr[outdata.first][outdata.second] == 'v') v_cnt++;
                    else if (arr[outdata.first][outdata.second] == 'k') k_cnt++;

                    for (int i = 0; i < 4; i++) {
                        int nx = outdata.first + X[i];
                        int ny = outdata.second + Y[i];
                        if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || arr[nx][ny]=='#') continue;
                        visit[nx][ny] = true;
                        q.push({ nx,ny });
                    }
                }

                if (k_cnt > v_cnt) k += k_cnt;
                else v += v_cnt;
            }

        }
    }

    printf("%d %d\n", k, v);
}