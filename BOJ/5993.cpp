#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

bool isOut(int, int);
int rowSize, colSize, startRow, startCol;
int X[] = { -1,-1,-1,0,1,1,1,0 }, Y[] = { -1,0,1,1,1,0,-1,-1 };
queue < pair<int, int> > q;
char pasture[103][103];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &colSize, &rowSize, &startCol, &startRow);
    startRow--, startCol--;

    for (int row = rowSize-1; row >=0; row--) {
        scanf(" %s", &pasture[row]);
    }

    q.push({ startRow,startCol });
    pasture[startRow][startCol] = '*';

    int week = -1;
    while (!q.empty()) {
        week++;
        int size = q.size();
        for (int idx = 0; idx < size; idx++) {
            auto now = q.front();
            q.pop();

            for (int dir = 0; dir < 8; dir++) {
                int nextRow = now.first + X[dir];
                int nextCol = now.second + Y[dir];

                if (isOut(nextRow, nextCol) || pasture[nextRow][nextCol] == '*') {
                    continue;
                }
                pasture[nextRow][nextCol] = '*';
                q.push({ nextRow,nextCol });
            }
        }
    }
    printf("%d\n", week);
}

bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x >= rowSize || y >= colSize);
}