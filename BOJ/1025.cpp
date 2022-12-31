#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans = -1, arr[10][10];


bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x > n - 1 || y > m - 1);
}

void solve(int x, int y, int addX, int addY) {
    int value = 0;
    int nextX = x, nextY = y;
    while (!isOut(nextX, nextY)) {
        value = value * 10 + arr[nextX][nextY];
        int sq = sqrt(value);
        if (sq * sq == value)
            ans = max(ans, value);
        nextX += addX;
        nextY += addY;
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &arr[i][j]);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int sq = sqrt(arr[i][j]);
            if (sq * sq == arr[i][j])
                ans = max(ans, arr[i][j]);
            for (int k = -n + 1; k < n; k++) {
                for (int l = -m + 1; l < m; l++) {
                    if (k == 0 && l == 0) continue;
                    solve(i, j, k, l);
                }
            }
        }
    }
    printf("%d\n", ans);
} 
