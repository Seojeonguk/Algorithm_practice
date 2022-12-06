#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

void melting();
bool reachable();
deque<pair<int, int> > swanPlaces,waters,nextSwanPlaces,nextWaters;
vector<pair<int, int> > swans;
int rowSize, colSize;
char lakes[1502][1502];
bool visit[1502][1502];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &rowSize, &colSize);

    for (int row = 0; row < rowSize; row++) {
        scanf(" %s", &lakes[row]);
        for (int col = 0; col < colSize; col++) {
            if (lakes[row][col] != 'X') {
                waters.push_back({ row,col });
            }
            if (lakes[row][col] == 'L') {
                swans.push_back({ row,col });
            }
        }
    }
    swanPlaces.push_back({ swans[0] });
    visit[swans[0].first][swans[0].second] = true;
    int answer = 0;
    bool isArrive = false;
    while (!isArrive) {
        bool isArrive = reachable();
        if (isArrive) {
            break;
        }
        melting();
        answer++;
        swanPlaces = nextSwanPlaces;
        waters = nextWaters;
        nextSwanPlaces.clear();
        nextWaters.clear();
    }
    printf("%d\n", answer);
}

bool reachable() {
    while (!swanPlaces.empty()) {
        pair<int, int> now = swanPlaces.front();
        swanPlaces.pop_front();

        if (now.first == swans[1].first && now.second == swans[1].second) {
            return true;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.first + X[dir];
            int nextCol = now.second + Y[dir];

            if (nextRow < 0 || nextCol < 0 || nextRow > rowSize - 1 || nextCol > colSize - 1 || visit[nextRow][nextCol]) {
                continue;
            }
            if (lakes[nextRow][nextCol] == 'X') {
                nextSwanPlaces.push_back({ nextRow,nextCol });
            }
            else if (lakes[nextRow][nextCol] != 'X') {
                swanPlaces.push_back({ nextRow,nextCol });
            }
            visit[nextRow][nextCol] = true;
        }
    }
    return false;
}

void melting() {
    while(!waters.empty()) {
        pair<int, int> now = waters.front();
        waters.pop_front();

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = now.first + X[dir];
            int nextCol = now.second + Y[dir];

            if (nextRow < 0 || nextCol < 0 || nextRow > rowSize - 1 || nextCol > colSize - 1) {
                continue;
            }
            if (lakes[nextRow][nextCol] == 'X') {
                lakes[nextRow][nextCol] = '.';
                nextWaters.push_back({ nextRow,nextCol });
            }
        }
    }
}