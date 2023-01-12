#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, seats[21][21], studentNum;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
struct studentInfo {
    int favoriteStudents[4];
}si[401];
int satisfactions[] = { 0,1,10,100,1000 };

bool isOut(int x, int y) {
    return (x<0 || y<0 || x>n - 1 || y>n - 1);
}

pair<int,int> findAdjaccentFavoriteStudent(int x, int y,int favoriteStudents[]) {
    int favoriteCnt = 0;
    int emptyCnt = 0;
    for (int dir = 0; dir < 4; dir++) {
        int nextX = x + X[dir];
        int nextY = y + Y[dir];
        if (isOut(nextX, nextY)) continue;

        if (!seats[nextX][nextY]) {
            emptyCnt++;
            continue;
        }
        for (int i = 0; i < 4; i++) {
            if (seats[nextX][nextY] == favoriteStudents[i]) {
                favoriteCnt++;
                break;
            }

        }
    }
    return { favoriteCnt, emptyCnt };
}

bool isRenew(int favoriteStudentCnt, int adjacentEmptyCnt, pair<int, int> adjacentInfo) {
    if (favoriteStudentCnt < adjacentInfo.first) return true;
    if (favoriteStudentCnt == adjacentInfo.first && adjacentEmptyCnt < adjacentInfo.second) return true;
    return false;
}

pair<int, int> findSeat(studentInfo& si) {
    pair<int, int> seat = { -1,-1 };
    int favoriteStudentCnt = 0;
    int adjacentEmptyCnt = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (seats[i][j]) continue;

            pair<int,int> adjacentInfo = findAdjaccentFavoriteStudent(i, j, si.favoriteStudents);

            if (isRenew(favoriteStudentCnt,adjacentEmptyCnt,adjacentInfo)) {
                seat = { i,j };
                favoriteStudentCnt = adjacentInfo.first;
                adjacentEmptyCnt = adjacentInfo.second;
            }
        }
    }
    if (seat.first == -1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!seats[i][j]) {
                    seat = { i,j };
                    break;
                }
            }
            if (seat.first != -1) break;
        }
    }
    return seat;
}

int satisfaction(int x, int y) {
    int studentNum = seats[x][y];

    int cnt = 0;
    for (int dir = 0; dir < 4; dir++) {
        int nextX = x + X[dir];
        int nextY = y + Y[dir];

        if (isOut(nextX, nextY)) continue;

        for (int i = 0; i < 4; i++) {
            if (seats[nextX][nextY] == si[studentNum].favoriteStudents[i]) {
                cnt++;
                break;
            }
        }
    }
    return satisfactions[cnt];
}

int calSatisfaction() {
    int satisfactionSum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            satisfactionSum += satisfaction(i, j);
        }
    }
    return satisfactionSum;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    
    for (int i = 0; i < n * n; i++) {
        scanf("%d", &studentNum);
        for (int j = 0; j < 4; j++)
            scanf("%d", &si[studentNum].favoriteStudents[j]);

        pair<int, int> seat = findSeat(si[studentNum]);
        seats[seat.first][seat.second] = studentNum;
    }

    int satisfactionSum = calSatisfaction();

    printf("%d\n", satisfactionSum);
} 
