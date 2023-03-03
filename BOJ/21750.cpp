#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char arr[3];
pair<int, int> p[4];
int positions[4];
bool visit[64][64];
pair<int, int> parent[64][64];

int dir[8][2] = { {-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2} };

bool isOut(int x, int y) {
    return x < 0 || y < 0 || x>7 || y>7;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 4; i++) {
        scanf("%s", arr);
        positions[i] = (arr[0] - 'a') * 8 + (arr[1] - '1');
    }

    for (int i = 0; i < 64; i++)
        for (int j = 0; j < 64; j++)
            parent[i][j] = { -1,-1 };

    queue<pair<int, int> > q;
    q.push({ positions[0],positions[1] });
    visit[positions[0]][positions[1]] = true;
    while (!q.empty()) {
        auto cur = q.front();
        q.pop();

        //printf("%d %d %d %d\n", cur.first / 8, cur.first % 8, cur.second / 8, cur.second % 8);

        for (int i = 0; i < 8; i++) {
            int nx = cur.first / 8 + dir[i][0];
            int ny = cur.first % 8 + dir[i][1];
            int pos = nx * 8 + ny;
            if (isOut(nx,ny) || visit[pos][cur.second] || pos == cur.second) continue;
            visit[pos][cur.second] = true;
            q.push({ pos,cur.second });
            parent[pos][cur.second] = cur;
        }

        for (int i = 0; i < 8; i++) {
            int nx = cur.second / 8 + dir[i][0];
            int ny = cur.second % 8 + dir[i][1];
            int pos = nx * 8 + ny;
            if (isOut(nx,ny) || visit[cur.first][pos] || pos == cur.first) continue;
            visit[cur.first][pos] = true;
            q.push({ cur.first,pos });
            parent[cur.first][pos] = cur;
        }
    }

    if (!visit[positions[2]][positions[3]]) {
        puts("-1");
        return 0;
    }

    stack<pair<bool, pair<int,int>>> s;
    while (parent[positions[2]][positions[3]].first != -1) {
        auto tmp = parent[positions[2]][positions[3]];
        s.push({ positions[2] == tmp.first ? false : true ,{positions[2],positions[3]} });

        positions[2] = tmp.first;
        positions[3] = tmp.second;
    }

    printf("%d\n", s.size());

    while (!s.empty()) {
        bool isWhite = s.top().first;
        int cur = isWhite ? s.top().second.first : s.top().second.second;
        s.pop();

        printf("%c %c%d\n", isWhite ? 'W' : 'B', 'a' + cur / 8, 1 + cur % 8);
    }
}
