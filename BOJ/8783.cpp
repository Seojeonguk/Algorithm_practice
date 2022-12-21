#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
char freefields[1004][1004];
bool isVisit[1004][1004];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    
    while (t--) {
        scanf("%d", &n);
        memset(freefields, '.', sizeof freefields);
        memset(isVisit, false, sizeof isVisit);

        for (int i = 1; i <= n; i++)
            scanf("%s", freefields[i] + 1);

        queue<pair<int, int> > q;
        q.push({ 0,0 });
        isVisit[0][0] = true;
        while (!q.empty()) {
            pair<int, int> now = q.front();
            q.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = now.first + X[dir];
                int nextY = now.second + Y[dir];

                if (nextX < 0 || nextY < 0 || nextX > n+1 || nextY > n+1) {
                    continue;
                }

                if (isVisit[nextX][nextY] || freefields[nextX][nextY] == '#') {
                    continue;
                }
                isVisit[nextX][nextY] = true;
                q.push({ nextX,nextY });
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (!isVisit[i][j])
                    ans++;

        printf("%d\n", ans);
    }
}