#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

void setSector(int, int, int);
bool isOut(int, int);
int rowSize, colSize;
int gridPlate[2014][2014];
int sector[2014][2014];
int X[] = { 1,0,-1,0,1,1,-1,-1 }, Y[] = { 0,1,0,-1,1,-1,1,-1 };
bool visit[2014][2014];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif    
    scanf("%d %d", &rowSize, &colSize);

    for (int row = 1; row <= rowSize; row++) {
        for (int col = 1; col <= colSize; col++) {
            scanf("%d", &gridPlate[row][col]);
        }
    }

    for (int col = 0; col < colSize; col++) {
        gridPlate[0][col + 2] = 1;
        gridPlate[rowSize + 1][col] = 1;
    }
    for (int row = 0; row < rowSize; row++) {
        gridPlate[row + 2][0] = 1;
        gridPlate[row][colSize + 1] = 1;
    }

    setSector(0, colSize + 1, 1);
    setSector(rowSize + 1, 0, 2);


    if (sector[0][colSize + 1] == sector[rowSize + 1][0]) {
        puts("0");
        return 0;
    }
    for (int row = 1; row <= rowSize; row++) {
        for (int col = 1; col <= colSize; col++) {
            if ((row == 1 && col == 1) || (row == rowSize && col == colSize)) {
                continue;
            }
            if (gridPlate[row][col]) {
                continue;
            }
            bool isFindFirst = false;
            bool isFindSecond = false;

            for (int dir = 0; dir < 8; dir++) {
                int sectorNum = sector[row + X[dir]][col + Y[dir]];
                if (sectorNum == 1) {
                    isFindFirst = true;
                }
                if (sectorNum == 2) {
                    isFindSecond = true;
                }
            }
            if (isFindFirst && isFindSecond) {
                puts("1");
                return 0;
            }
        }
    }
    puts("2");
}

void setSector(int x, int y, int sectorNum) {
    if (sector[x][y]) {
        return;
    }
    queue<pair<int, int> > q;
    q.push({ x,y });
    sector[x][y] = sectorNum;
    visit[x][y] = true;
    while (!q.empty()) {
        pair<int, int> place = q.front();
        q.pop();

        for (int dir = 0; dir < 8; dir++) {
            int nextRow = place.first + X[dir];
            int nextCol = place.second + Y[dir];

            if (isOut(nextRow, nextCol) || visit[nextRow][nextCol] || !gridPlate[nextRow][nextCol]) {
                continue;
            }
            sector[nextRow][nextCol] = sectorNum;
            visit[nextRow][nextCol] = true;
            q.push({ nextRow,nextCol });
        }
    }
}


bool isOut(int row, int col) {
    return (row < 0 || col < 0 || row > rowSize + 1 || col > colSize + 1);
}