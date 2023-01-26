#include<cstdio>
#include<cstring>
#include<queue>
using namespace std;

int t, n;
int maps[102][102], dist[102][102];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

bool isOut(int x, int y) {
    return (x<0 || y<0 || x>n - 1 || y>n - 1);
}

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        memset(dist, 0x3f, sizeof dist);
        scanf("%d", &n);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                scanf("%1d", &maps[i][j]);

        priority_queue<pair<int, int> > pq;

        dist[0][0] = 0;
        pq.push({ 0,0 });

        while (!pq.empty()) {
            pair<int, int> now = pq.top();
            pq.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = now.second / 101 + X[dir];
                int nextY = now.second % 101 + Y[dir];

                if (isOut(nextX, nextY)) continue;
                int nextDist = -now.first + maps[nextX][nextY];
                if (nextDist < dist[nextX][nextY]) {
                    dist[nextX][nextY] = nextDist;
                    pq.push({ -nextDist,nextX * 101 + nextY % 101 });
                }

            }
        }

        printf("#%d %d\n", tc, dist[n-1][n-1]);
    }
}
