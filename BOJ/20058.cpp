#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

void rotation(int, int, int);
void melting();
int calLump(int, int);
bool isOut(int, int);
int icyRoad[1 << 6 + 1][1 << 6 + 1];
int icyRoadSize, queryCnt, query;
bool isVisit[1 << 6 + 1][1 << 6 + 1];
int X[] = { 1,0,-1,0 }, Y[] = { 0,-1,0,1 };
int nextX[] = { 0,1,1 }, nextY[] = { 1,1,0 };
int sizeX[] = { 1,0 }, sizeY[] = { 0,1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &icyRoadSize, &queryCnt);

    icyRoadSize = (1 << icyRoadSize);

    for (int row = 0; row < icyRoadSize; row++) {
        for (int col = 0; col < icyRoadSize; col++) {
            scanf("%d", &icyRoad[row][col]);
        }
    }

    for (int querys = 0; querys < queryCnt; querys++) {
        scanf("%d", &query);
        
        rotation(0, 0, query);
        melting();

        memset(isVisit, false, sizeof isVisit);
    }

    int remainingIce = 0;
    int maxLump = 0;
    for (int row = 0; row < icyRoadSize; row++) {
        for (int col = 0; col < icyRoadSize; col++) {
            remainingIce += icyRoad[row][col];
            if (icyRoad[row][col] && !isVisit[row][col]) {
                int lump = calLump(row,col);
                maxLump = max(maxLump, lump);
            }
        }
    }
    printf("%d\n%d\n", remainingIce, maxLump);
}

void rotation(int row, int col, int size) {
    for (int rotationCnt = 0; rotationCnt < (1<<size); rotationCnt++) {
        int startRow = row + rotationCnt;
        int startCol = col + rotationCnt;
        for (int i = 0; i < 3; i++) {
            int next = (1 << size) - 1 - 2 * rotationCnt;
            int nextStartRow = startRow + (nextX[i] * next);
            int nextStartCol = startCol + (nextY[i] * next);
            for (int j = 0; j < next; j++) {
                int nowRow = startRow;
                int nowCol = startCol + j;
                
                int nextRow = nextStartRow + (X[i] * j);
                int nextCol = nextStartCol + (Y[i] * j);

                swap(icyRoad[nowRow][nowCol], icyRoad[nextRow][nextCol]);
            }
        }
    }
    
    for (int dir = 0; dir < 2; dir++) {
        int nextRow = row + (sizeX[dir] * (1<<size));
        int nextCol = col + (sizeY[dir] * (1<<size));

        if (isOut(nextRow, nextCol) || isVisit[nextRow][nextCol]) {
            continue;
        }
        isVisit[nextRow][nextCol] = true;
        rotation(nextRow, nextCol, size);
    }
}

void melting() {
    vector<pair<int, int> > meltPlace;

    for (int row = 0; row < icyRoadSize; row++) {
        for (int col = 0; col < icyRoadSize; col++) {
            int meltCnt = 0;
            if (!icyRoad[row][col]) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row + X[dir];
                int nextCol = col + Y[dir];
                if (isOut(nextRow, nextCol) || !icyRoad[nextRow][nextCol]) {
                    meltCnt++;
                }
            }
            if (meltCnt >= 2) {
                meltPlace.push_back({ row,col });
            }
        }
    }

    for (pair<int, int> place : meltPlace) {
        icyRoad[place.first][place.second]--;
    }
}

int calLump(int row, int col) {
    int lumpAmount = 0;
    queue<pair<int, int> > q;
    isVisit[row][col] = true;
    q.push({ row,col });

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        lumpAmount++;

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.first + X[dir];
            int nextCol = now.second + Y[dir];

            if (isOut(nextRow, nextCol) || isVisit[nextRow][nextCol] || !icyRoad[nextRow][nextCol ]) {
                continue;
            }
            isVisit[nextRow][nextCol] = true;
            q.push({ nextRow,nextCol });
        }
    }

    return lumpAmount;
}

bool isOut(int row, int col) {
    return (row < 0 || col < 0 || row >= icyRoadSize || col >= icyRoadSize);
}