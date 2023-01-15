#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans;
int planet[1002][1002];
bool isVisit[1002][1002];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

void solve(int x, int y) {
    queue<pair<int, int> > q;
    isVisit[x][y] = true;
    q.push({ x,y });

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nextX = (now.first + X[dir] + n) % n;
            int nextY = (now.second + Y[dir] + m) % m;

            if (isVisit[nextX][nextY] || planet[nextX][nextY] == 1) continue;
            isVisit[nextX][nextY] = true;
            q.push({ nextX,nextY });
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            scanf("%d", &planet[i][j]);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!planet[i][j] && !isVisit[i][j]) {
                ans++;
                solve(i, j);
            }
        }
    }

    printf("%d\n", ans);
} 
