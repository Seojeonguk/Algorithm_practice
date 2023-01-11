#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans;
int X[] = { -1,0,1,0 }, Y[] = { 0,-1,0,1 };

void solve(vector<vector<int> >& v,int cnt) {
    if (cnt == 5) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ans = max(ans, v[i][j]);
        return;
    }
    for (int dir = 0; dir < 4; dir++) {
        vector<vector<int> > v2(v);
        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;

            if (dir == 0) x = n - 1, y = i;
            else if (dir == 1) x = i, y = n - 1;
            else if (dir == 2) x = 0, y = i;
            else if (dir == 3) x = i, y = 0;
            int stx = x, sty = y;
            for (int j = 1; j < n; j++) {
                int nextX = stx + X[dir]*j;
                int nextY = sty + Y[dir]*j;

                if (!v2[nextX][nextY]) continue;
                if (v2[x][y] == v2[nextX][nextY]) {
                    v2[x][y] *= 2;
                    v2[nextX][nextY] = 0;
                    x += X[dir];
                    y += Y[dir];
                }
                else {
                    if (v2[x][y]) {
                        x += X[dir];
                        y += Y[dir];
                    }
                    v2[x][y] = v2[nextX][nextY];
                    if(x!=nextX || y!=nextY)
                    v2[nextX][nextY] = 0;
                }
            }
        }

        solve(v2, cnt + 1);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    vector<vector<int> > v(n, vector<int>(n));

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &v[i][j]);

    solve(v,0);

    printf("%d\n", ans);
}
