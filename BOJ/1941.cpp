#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

void findSevenPrincess(int, int, int);
bool isAdjoin(int);
bool isOut(int, int);
int girlsSize = 5;
char girls[6][6];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int answer;
bool isSelect[6][6];
bool isVisit[6][6];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int row = 0; row < girlsSize; row++) {
        scanf(" %s", &girls[row]);
    }

    findSevenPrincess(-1, 0, 0);

    printf("%d\n", answer);
}

void findSevenPrincess(int idx, int YCnt, int cnt) {
    if (cnt == 7) {
        if (isAdjoin(idx)) {
            answer++;
        }
        return;
    }
    for (int nextIdx = idx + 1; nextIdx < girlsSize * girlsSize; nextIdx++) {
        int nextRow = nextIdx / 5;
        int nextCol = nextIdx % 5;
        if (isSelect[nextRow][nextCol]) {
            continue;
        }
        int nextYCnt = YCnt;
        if (girls[nextRow][nextCol] == 'Y') {
            nextYCnt++;
        }
        if (nextYCnt >= 4) {
            continue;
        }
        isSelect[nextRow][nextCol] = true;
        findSevenPrincess(nextIdx, nextYCnt, cnt + 1);
        isSelect[nextRow][nextCol] = false;
    }
}

bool isAdjoin(int idx) {
    memset(isVisit, false, sizeof isVisit);
    int cnt = 0;
    queue<pair<int, int> > q;
    q.push({ idx / 5,idx % 5 });
    isVisit[idx / 5][idx % 5] = true;
    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        cnt++;

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.first + X[dir];
            int nextCol = now.second + Y[dir];

            if (isOut(nextRow, nextCol) || !isSelect[nextRow][nextCol] || isVisit[nextRow][nextCol]) {
                continue;
            }
            isVisit[nextRow][nextCol] = true;
            q.push({ nextRow,nextCol });
        }
    }
    return cnt == 7;
}

bool isOut(int x, int y) {
    return (x < 0 || y<0 || x>girlsSize || y>girlsSize);
}