#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, m;
char pastures[102][102];
bool isVisit[102][102];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

void grouping(int x, int y) {
    queue<pair<int, int> > q;
    q.push({ x,y });
    isVisit[x][y] = true;

    while (!q.empty()) {
        auto now = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nextX = now.first + X[dir];
            int nextY = now.second + Y[dir];

            if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1 || isVisit[nextX][nextY] || pastures[nextX][nextY] != '#')
                continue;

            isVisit[nextX][nextY] = true;
            q.push({ nextX,nextY });
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    while (t--) {
        memset(isVisit, false, sizeof isVisit);
        int ans = 0;
        scanf("%d %d", &n, &m);

        for (int i = 0; i < n; i++)
            scanf("%s", pastures[i]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pastures[i][j] == '#' && !isVisit[i][j]) {
                    grouping(i, j);
                    ans++;
                }
            }
        }
        printf("%d\n", ans);
    }
}
