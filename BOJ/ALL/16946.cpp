#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, arr[1005][1005],walllabel[1005][1005],wallsize[2000003],cnt;
bool visit[2000003];
int X[4] = { 1,0,-1,0 }, Y[4] = { 0,1,0,-1 };

void labeling(int x, int y) {
    int label_cnt = 0;
    walllabel[x][y] = ++cnt;
    queue<pair<int, int> > q;
    q.push({ x,y });

    while (!q.empty()) {
        auto outdata = q.front();
        q.pop();

        label_cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = outdata.first + X[i];
            int ny = outdata.second + Y[i];

            if (walllabel[nx][ny] || arr[nx][ny]) continue;
            walllabel[nx][ny] = cnt;
            q.push({ nx,ny });
        }
    }

    wallsize[cnt] = label_cnt;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    memset(arr, -1, sizeof arr);

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            scanf("%1d", &arr[i][j]);

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            if (arr[i][j] == 0 && !walllabel[i][j])
                labeling(i, j);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (arr[i][j] == 0) printf("0");
            else {
                int sum = 1;
                for (int d = 0; d < 4; d++) {
                    int nx = i + X[d];
                    int ny = j + Y[d];
                    if (arr[nx][ny] == 0  && !visit[walllabel[nx][ny]]) {
                        visit[walllabel[nx][ny]] = true;
                        sum += wallsize[walllabel[nx][ny]];
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nx = i + X[d];
                    int ny = j + Y[d];
                    visit[walllabel[nx][ny]] = false;
                }
                printf("%d", sum % 10);
            }
        }
        puts("");
    }
}