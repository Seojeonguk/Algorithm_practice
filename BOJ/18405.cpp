#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int testTube[202][202];
int testTubeSize, virusCnt, times;
pair<int, int> place;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
struct virus {
    int num,row,col;
};
struct compare {
    bool operator()(virus& a, virus& b) {
        return a.num > b.num;
    }
};
priority_queue<virus,vector<virus>,compare> pq;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &testTubeSize, &virusCnt);
    for (int row = 1; row <= testTubeSize; row++) {
        for (int col = 1; col <= testTubeSize; col++) {
            scanf("%d", &testTube[row][col]);
            if (testTube[row][col]) {
                pq.push({ testTube[row][col],row,col });
            }
        }
    }

    scanf("%d %d %d", &times, &place.first, &place.second);

    for (int time = 0; time < times; time++) {
        priority_queue<virus,vector<virus>,compare> nextPq;
        while (!pq.empty()) {
            virus virusInfo = pq.top();
            pq.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = virusInfo.row + X[dir];
                int nextCol = virusInfo.col + Y[dir];

                if (nextRow<1 || nextCol<1 || nextRow>testTubeSize || nextCol>testTubeSize || testTube[nextRow][nextCol]) {
                    continue;
                }
                testTube[nextRow][nextCol] = virusInfo.num;
                nextPq.push({ virusInfo.num,nextRow,nextCol });
            }
        }
        pq = nextPq;
    }
    printf("%d\n", testTube[place.first][place.second]);
}