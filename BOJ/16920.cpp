#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, p;
int castle_cnt[10];
int can_move[10];
char grid[1002][1002];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
queue<pair<int, int> > q[10];

bool isOut(int x, int y) {
    return (x<0 || y<0 || x>n - 1 || y>m - 1);
}

void solve(int x) {
    for (int i = 0; i < can_move[x]; i++) {
        int size = q[x].size();
        for (int j = 0; j < size; j++) {
            int now_x = q[x].front().first;
            int now_y = q[x].front().second;
            q[x].pop();

            for (int d = 0; d < 4; d++) {
                int next_x = now_x + X[d];
                int next_y = now_y + Y[d];
                
                if (isOut(next_x, next_y) || grid[next_x][next_y]!='.')
                    continue;

                grid[next_x][next_y] = grid[now_x][now_y];
                q[x].push({ next_x,next_y });
                castle_cnt[x]++;
            }
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &p);

    for (int i = 0; i < p; i++) {
        scanf("%d", &can_move[i]);
        can_move[i] = min(can_move[i], n * m);
    }

    for (int i = 0; i < n; i++) {
        scanf(" %s", grid[i]);
        for (int j = 0; j < m; j++) {
            if ('0' <= grid[i][j] && grid[i][j] <= '9') 
                q[grid[i][j] - '1'].push({ i,j });
        }
    }

    for (int i = 0; i < p; i++)
        castle_cnt[i] = q[i].size();

    while (1) {
        bool ismore = false;
        for (int i = 0; i < p; i++)
            if (!q[i].empty())
                ismore = true;

        if (!ismore) break;

        for (int i = 0; i < p; i++) {
            solve(i);
        }
    }

    for (int i = 0; i < p; i++)
        printf("%d ", castle_cnt[i]);
}