#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

void calMountainTop(int, pair<int, int>);
int rowSize, colSize;
bool isVisit[101][81];
int mountainHeights[101][81];
priority_queue<pair<int, pair<int, int> > > pq;
pair<int, int> xy[] = { {-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1} };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &rowSize, &colSize);

    for (int row = 0; row < rowSize; row++) {
        for (int col = 0; col < colSize; col++) {
            scanf("%d", &mountainHeights[row][col]);
            if (mountainHeights[row][col]) {
                pq.push({ mountainHeights[row][col],{row,col} });
            }
        }
    }

    int ans = 0;
    while (!pq.empty()) {
        auto top = pq.top();
        pq.pop();

        

        if (isVisit[top.second.first][top.second.second]) {
            continue;
        }

        calMountainTop(top.first, top.second);
        ans++;
    }
    printf("%d\n", ans);
}

void calMountainTop(int topHeight, pair<int, int> pos) {
    queue<pair<int, int> > q;
    q.push(pos);
    isVisit[pos.first][pos.second] = true;

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 8; dir++) {
            int nextRow = now.first + xy[dir].first;
            int nextCol = now.second + xy[dir].second;

            if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
                continue;
            }
            if (isVisit[nextRow][nextCol] || !mountainHeights[nextRow][nextCol] || mountainHeights[now.first][now.second] < mountainHeights[nextRow][nextCol]) {
                continue;
            }
            isVisit[nextRow][nextCol] = true;
            q.push({ nextRow,nextCol });
        }
    }
}