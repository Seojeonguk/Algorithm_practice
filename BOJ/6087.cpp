#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool isOut(int, int);
int rowSize, colSize;
char maps[102][102];
int cost[102][102];
int x = -1, y = -1;
queue<pair<int,int> > q;
int X[] = { -1,1,0,0 }, Y[] = { 0,0,-1,1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &colSize, &rowSize);
    for (int row = 0; row < rowSize; row++) {
        scanf(" %s", &maps[row]);
        for (int col = 0; col < colSize; col++) {
            if (maps[row][col] == 'C') {
                if (y == -1) x = row, y = col;
                else q.push({ row,col });
            }
        }
    }
    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.first + X[dir];
            int nextCol = now.second + Y[dir];

            while (!isOut(nextRow, nextCol) && maps[nextRow][nextCol] != '*') {
                if (!cost[nextRow][nextCol]) {
                    cost[nextRow][nextCol] = cost[now.first][now.second] + 1;
                    q.push({ nextRow,nextCol });
                }
                nextRow += X[dir];
                nextCol += Y[dir];
            }
        }
    }

    printf("%d\n", cost[x][y] - 1);
}

bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x >= rowSize || y >= colSize);
}