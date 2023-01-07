#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int, int> p[] = { {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1} };
int tc,n, spots[42][42];
bool isVisit[42][42];

bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x > n - 1 || y > n - 1);
}

void visit(int x, int y) {
    isVisit[x][y] = true;
    queue<pair<int, int> > q;
    q.push({ x,y });

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 8; dir++) {
            int nextX = now.first + p[dir].first;
            int nextY = now.second + p[dir].second;

            if (isOut(nextX, nextY) || isVisit[nextX][nextY] || !spots[nextX][nextY]) {
                continue;
            }
            isVisit[nextX][nextY] = true;
            q.push({ nextX,nextY });
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (scanf("%d", &n) != EOF) {
        memset(isVisit, false, sizeof isVisit);
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                scanf("%1d", &spots[i][j]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisit[i][j] && spots[i][j]) {
                    visit(i, j);
                    ans++;
                }
            }
        }

        printf("Case #%d: %d\n", ++tc, ans);
    }
}
