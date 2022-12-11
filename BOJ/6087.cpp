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
struct laser {
    int turnCnt, x, y, dir;
};
struct compare {
    bool operator()(laser& a, laser& b) {
        return a.turnCnt > b.turnCnt;
    }
};
priority_queue<laser, vector<laser>, compare> pq;
int X[] = { -1,1,0,0 }, Y[] = { 0,0,-1,1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &colSize, &rowSize);
    for (int row = 0; row < rowSize; row++) {
        scanf(" %s", &maps[row]);
        for (int col = 0; col < colSize; col++) {
            cost[row][col] = INT32_MAX;
            if (maps[row][col] == 'C' && pq.empty()) {
                cost[row][col] = 0;
                pq.push({ -1,row,col,-1 });
                maps[row][col] = '.';
            }
        }
    }
    while (!pq.empty()) {
        laser now = pq.top();
        pq.pop();

        if (maps[now.x][now.y] == 'C') {
            printf("%d\n", now.turnCnt);
            return 0;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.x + X[dir];
            int nextCol = now.y + Y[dir];
            int nextTurnCnt = now.turnCnt + (now.dir != dir);
            int nextDir = dir;

            if (isOut(nextRow, nextCol) || nextTurnCnt > cost[nextRow][nextCol] || maps[nextRow][nextCol] == '*') {
                continue;
            }

            cost[nextRow][nextCol] = nextTurnCnt;
            pq.push({ nextTurnCnt,nextRow,nextCol,nextDir });
        }
    }
}

bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x >= rowSize || y >= colSize);
}