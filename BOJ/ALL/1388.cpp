#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, ans;
bool visit[53][53];
char ground[53][53];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf("%s", &ground[i]);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!visit[i][j]) {
                ans++;
                queue<pair<int, int> > q;
                q.push({ i,j });
                visit[i][j] = true;

                while (!q.empty()) {
                    auto outdata = q.front();
                    q.pop();

                    int nx = outdata.first + (ground[i][j] == '|' ? 1 : 0);
                    int ny = outdata.second + (ground[i][j] == '-' ? 1 : 0);

                    if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || ground[i][j] != ground[nx][ny])
                        continue;

                    q.push({ nx,ny });
                    visit[nx][ny] = true;
                }
            }
        }
    }

    printf("%d\n", ans);
}