#include<cstdio>
#include<queue>
#include<cstring>
using namespace std;

char mines[302][302];
int surroundingmines[302][302];
int t,n;
int xy[8][2] = { {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1} };

bool isOut(int x, int y) {
    return (x<1 || y<1 || x>n || y>n);
}

int calSurroundingmines(int x, int y) {
    int mineCnt = 0;
    for (int dir = 0; dir < 8; dir++) {
        int nextX = x + xy[dir][0];
        int nextY = y + xy[dir][1];
        mineCnt += (mines[nextX][nextY] == '*');
    }
    return mineCnt;
}

void click(int x, int y) {
    surroundingmines[x][y] = -1;
    queue<pair<int, int> > q;
    q.push({ x,y });

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        for (int dir = 0; dir < 8; dir++) {
            int nextX = now.first + xy[dir][0];
            int nextY = now.second + xy[dir][1];

            if (isOut(nextX, nextY) || surroundingmines[nextX][nextY] == -1) continue;
            if (!surroundingmines[nextX][nextY])
                q.push({ nextX,nextY });
            surroundingmines[nextX][nextY] = -1;
        }
    }
}

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        memset(mines, '.', sizeof mines);
        memset(surroundingmines, -1, sizeof surroundingmines);

        scanf("%d", &n);
        for (int i = 1; i <= n; i++)
            scanf(" %s", mines[i] + 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (mines[i][j] == '.') {
                    int mineCnt = calSurroundingmines(i, j);
                    surroundingmines[i][j] = mineCnt;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!surroundingmines[i][j]) {
                    click(i, j);
                    ans++;
                }
            }
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (mines[i][j] == '.' && surroundingmines[i][j] != -1)
                    ans++;

        printf("#%d %d\n", tc, ans);
    }
}
