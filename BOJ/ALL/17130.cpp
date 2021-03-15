#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, sx, sy;
char info[1002][1002];
int dp[1002][1002];
int X[] = { 1,0,-1 }, Y[] = { 1,1,1 };
const int init_value = -1e9;

int solve(int x, int y) {
    int& ret = dp[x][y];
    if (ret != -1) return ret;
    ret = init_value;

    if (info[x][y] == 'O') ret = 0;
    for (int i = 0; i < 3; i++) {
        int nx = x + X[i];
        int ny = y + Y[i];
        if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || info[nx][ny] == '#') continue;
        int temp = solve(nx, ny);
        if (temp > init_value) ret = max(ret, temp);
    }
    if (ret > init_value && info[x][y] == 'C') ret++;
    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        scanf("%s", info[i]);
        for (int j = 0; j < m; j++)
            if (info[i][j] == 'R')
                sx = i, sy = j;
    }

    memset(dp, -1, sizeof dp);
    printf("%d\n", solve(sx, sy) == init_value ? -1 : solve(sx, sy));
}