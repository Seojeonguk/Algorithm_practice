#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

pair<int, pair<int, int> > findPerson(), findDestination(pair<int, int>);
int area[22][22];
pair<int, int> destination[22][22];
int areaSize, personCnt, currentFuel, finishCnt;
pair<int, int> driverPlace;
pair<int, int> personStart, personEnd;
bool visit[22][22];
int X[] = { -1,0,0,1 }, Y[] = { 0,-1,1,0 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &areaSize, &personCnt, &currentFuel);
    for (int row = 1; row <= areaSize; row++) {
        for (int col = 1; col <= areaSize; col++) {
            scanf("%d ", &area[row][col]);
        }
    }
    scanf("%d %d", &driverPlace.first, &driverPlace.second);

    for (int idx = 0, personNum = 2; idx < personCnt; idx++, personNum++) {
        scanf("%d %d %d %d", &personStart.first, &personStart.second, &personEnd.first, &personEnd.second);
        area[personStart.first][personStart.second] = personNum;
        destination[personStart.first][personStart.second] = personEnd;
    }

    for (int time = 0; time < personCnt; time++) {
        pair<int, pair<int, int> > nextPerson = findPerson();
        //printf("%d %d : cost %d\n", nextPerson.second.first, nextPerson.second.second, nextPerson.first);
        if (nextPerson.first == -1) {
            break;
        }
        pair<int, pair<int, int> > nextDestination = findDestination(nextPerson.second);

        if (nextDestination.first == -1) {
            break;
        }
        int usedFuel = nextPerson.first + nextDestination.first;
        if (usedFuel > currentFuel) {
            break;
        }
        finishCnt++;
        currentFuel -= usedFuel;
        currentFuel += 2 * nextDestination.first;
        area[nextPerson.second.first][nextPerson.second.second] = 0;
        destination[nextPerson.second.first][nextPerson.second.second] = { 0,0 };
        driverPlace = nextDestination.second;
    }

    printf("%d\n", finishCnt == personCnt ? currentFuel : -1);
}

pair<int, pair<int, int > > findPerson() {
    memset(visit, false, sizeof visit);
    queue<pair<int, pair<int, int> > > pq;
    pq.push({ 0,driverPlace });
    visit[driverPlace.first][driverPlace.second] = true;
    while (!pq.empty()) {
        bool isfind = false;
        int dis = 0, x = 9999, y = 9999;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            pair<int, pair<int, int> > now = pq.front();
            int nowRow = now.second.first;
            int nowCol = now.second.second;
            pq.pop();

            if (area[nowRow][nowCol]) {
                
                isfind = true;
                dis = now.first;
                if (x > nowRow) {
                    x = nowRow;
                    y = nowCol;
                }
                else if (x == nowRow) {
                    y = min(y, nowCol);
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = nowRow + X[dir];
                int nextCol = nowCol + Y[dir];

                if (nextRow < 1 || nextCol <1 || nextRow>areaSize || nextCol > areaSize || visit[nextRow][nextCol] || area[nextRow][nextCol] == 1) {
                    continue;
                }
                visit[nextRow][nextCol] = true;
                pq.push({ now.first + 1,{nextRow,nextCol} });
            }
        }
        if (isfind) {
            return { dis,{x,y} };
        }
    }
    return { -1,{-1,-1} };
}

pair<int, pair<int, int> > findDestination(pair<int, int> startPlace) {
    memset(visit, false, sizeof visit);
    queue<pair<int, pair<int, int> > > pq;
    pq.push({ 0,startPlace });
    visit[startPlace.first][startPlace.second] = true;

    int destinationRow = destination[startPlace.first][startPlace.second].first;
    int destinationCol = destination[startPlace.first][startPlace.second].second;

    while (!pq.empty()) {
        pair<int, pair<int, int> > now = pq.front();
        int nowRow = now.second.first;
        int nowCol = now.second.second;

        pq.pop();

        if (nowRow == destinationRow && nowCol == destinationCol) {
            return now;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = nowRow + X[dir];
            int nextCol = nowCol + Y[dir];

            if (nextRow < 1 || nextCol < 1 || nextRow > areaSize || nextCol > areaSize || visit[nextRow][nextCol] || area[nextRow][nextCol] == 1) {
                continue;
            }
            visit[nextRow][nextCol] = true;
            pq.push({ now.first + 1,{nextRow,nextCol} });
        }
    }
    return { -1,{-1,-1} };
}
