#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int boxCnt[5];
int score[5] = { 6,3,2,1,2 };
int teamScore[2];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int team = 0; team < 2; team++) {
        for (int idx = 0; idx < 5; idx++) {
            scanf("%d", &boxCnt[idx]);
            teamScore[team] += boxCnt[idx] * score[idx];
        }
    }
    printf("%d %d\n", teamScore[0], teamScore[1]);
}