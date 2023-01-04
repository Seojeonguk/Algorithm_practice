#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, a, b, robotNum, isCrash;
int isOn[101][101];
char d, command;
struct robot {
    int x, y, d;
};
vector<robot> v;
int robotCnt, commandCnt, repetitionCnt;
int crashRobotNum, crashRobotNum2;
int X[] = { -1,0,1,0 }, Y[] = { 0,1,0,-1 };

int charToInt(char cDir) {
    int iDir = 0;

    if (cDir == 'N') iDir = 0;
    else if (cDir == 'E') iDir = 1;
    else if (cDir == 'S') iDir = 2;
    else if (cDir == 'W') iDir = 3;

    return iDir;
}

bool isOut(robot r) {
    return (r.x < 1 || r.y < 1 || r.x > n || r.y > m);
}

bool isRobotCrash(robot r) {
    return isOn[r.x][r.y];
}

void movingRobot() {
    robot& r = v[robotNum];
    isOn[r.x][r.y] = 0;
    r.x += X[r.d];
    r.y += Y[r.d];

    if (isOut(r)) {
        isCrash = 1;
        crashRobotNum = robotNum;
        return;
    }

    if (isRobotCrash(r)) {
        isCrash = 2;
        crashRobotNum = robotNum;
        crashRobotNum2 = isOn[r.x][r.y];
        return;
    }
    isOn[r.x][r.y] = robotNum;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &m, &n);
    scanf("%d %d", &robotCnt, &commandCnt);

    v.resize(robotCnt + 1);

    robot r;
    for (int robotIdx = 1; robotIdx <= robotCnt; robotIdx++) {
        scanf("%d %d %c", &r.y, &r.x, &d);
        r.x = n - r.x + 1;
        r.d = charToInt(d);
        isOn[r.x][r.y] = robotIdx;
        v[robotIdx] = r;
    }
    
    while (commandCnt--) {
        scanf("%d %c %d", &robotNum, &command, &repetitionCnt);

        if (command == 'L' || command == 'R')
            repetitionCnt %= 4;

        while (repetitionCnt--) {
            if (command == 'L') v[robotNum].d = (v[robotNum].d + 3) % 4;
            else if (command == 'R') v[robotNum].d = (v[robotNum].d + 1) % 4;
            else movingRobot();

            if (isCrash) break;
        }
        if (isCrash) break;
    }
    if (isCrash == 1)
        printf("Robot %d crashes into the wall\n", crashRobotNum);
    else if (isCrash == 2)
        printf("Robot %d crashes into robot %d\n", crashRobotNum, crashRobotNum2);
    else puts("OK");
}
