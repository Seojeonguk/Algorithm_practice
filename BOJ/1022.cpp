#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int x, y, moveCnt = 1, moveSize = 1, dir, turnCnt, cnt, val = 1;
int graphPaper[53][5];
int X[] = { 0,-1,0,1 }, Y[] = { 1,0,-1,0 };
int r1, c1, r2, c2;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &r1, &c1, &r2, &c2);
    while (cnt != (r2 - r1 + 1) * (c2 - c1 + 1)) {
        if (r1 <= x && x <= r2 && c1 <= y && y <= c2) {
            graphPaper[x - r1][y - c1] = val;
            cnt++;
        }
        x += X[dir];
        y += Y[dir];
        val++;
        moveCnt--;

        if (!moveCnt) {
            dir = (dir + 1) % 4;
            turnCnt++;
            if (turnCnt == 2) {
                moveSize++;
                turnCnt = 0;
            }
            moveCnt = moveSize;
        }
    }

    int maxlength = 0;
    for (int i = 0; i <= r2 - r1; i++) {
        for (int j = 0; j <= c2 - c1; j++) {
            maxlength = max(maxlength, (int)log10(graphPaper[i][j]));
        }
    }

    for (int i = 0; i <= r2 - r1; i++) {
        for (int j = 0; j <= c2 - c1; j++) {
            int length = (int)log10(graphPaper[i][j]);
            for (int k = 0; k < maxlength - length; k++)
                printf(" ");
            printf("%d ", graphPaper[i][j]);
        }
        puts("");
    }
}