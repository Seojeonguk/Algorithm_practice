#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
char geosurvcomp[103][103];
bool visit[103][103];
int X[] = { 1,1,1,0,0,-1,-1,-1 }, Y[] = { 0,1,-1,1,-1,0,1,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (scanf("%d %d", &n, &m)) {
        if (!n && !m) break;
        memset(visit, false, sizeof visit);
        scanf("%d %d", &n, &m);

        for (int i = 0; i < n; i++)
            scanf("%s", &geosurvcomp[i]);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (geosurvcomp[i][j] == '@' && !visit[i][j]) {
                    queue <pair<int, int> > q;

                    ans++;
                    visit[i][j] = true;
                    q.push({ i,j });

                    while (!q.empty()) {
                        auto outdata = q.front();
                        q.pop();

                        for (int d = 0; d < 8; d++) {
                            int nx = outdata.first + X[d];
                            int ny = outdata.second + Y[d];

                            if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || geosurvcomp[nx][ny] == '*')
                                continue;

                            visit[nx][ny] = true;
                            q.push({ nx,ny });
                        }
                    }
                }
            }
        }
        printf("%d\n", ans);
    }
}