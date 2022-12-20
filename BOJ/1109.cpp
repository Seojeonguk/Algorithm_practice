#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

bool isOut(int, int);
int dfs(int);
int n, m;
char islands[53][53];
bool isVisit[53][53];
queue<pair<int, pair<int, int > > > sea, island;
pair<int, int> p[] = { {1,0},{-1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1} };
vector<int> v[2501];
int answer[2501];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf(" %c", &islands[i][j]);

            sea.push({ 0,{ 0,j} });
            sea.push({ 0,{n + 1,j} });
            isVisit[0][j] = isVisit[n + 1][j] = true;
        }
        sea.push({ 0,{i,0} });
        sea.push({ 0,{i,m + 1} });
        isVisit[i][0] = isVisit[i][m + 1] = true;
    }

    deque<int> answers;
    int islandNum = 0;
    while (!sea.empty() || !island.empty()) {
        while (!sea.empty()) {
            pair<int, pair<int, int> > now = sea.front();
            sea.pop();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = now.second.first + p[dir].first;
                int nextY = now.second.second + p[dir].second;

                if (isOut(nextX, nextY) || isVisit[nextX][nextY]) {
                    continue;
                }

                if (islands[nextX][nextY] == 'x') {
                    island.push({ now.first,{nextX,nextY} });
                }
                else {
                    isVisit[nextX][nextY] = true;
                    sea.push({ now.first,{nextX,nextY} });
                }
            }
        }

        while (!island.empty()) {
            pair<int, pair<int, int> > now = island.front();
            island.pop();

            if (isVisit[now.second.first][now.second.second]) {
                continue;
            }

            islandNum++;
            v[now.first].push_back(islandNum);
            queue<pair<int, int> > pq;
            pq.push(now.second);
            isVisit[now.second.first][now.second.second] = true;

            while (!pq.empty()) {
                pair<int, int> pqNow = pq.front();
                pq.pop();

                for (int dir = 0; dir < 8; dir++) {
                    int nextX = pqNow.first + p[dir].first;
                    int nextY = pqNow.second + p[dir].second;

                    if (isOut(nextX, nextY) || isVisit[nextX][nextY]) {
                        continue;
                    }

                    if (islands[nextX][nextY] == '.') {
                        sea.push({ islandNum,{nextX,nextY} });
                    }
                    else {
                        isVisit[nextX][nextY] = true;
                        pq.push({ nextX,nextY });
                    }
                }
            }
        }
    }

    if (v[0].empty()) {
        puts("-1");
        return 0;
    }
    dfs(0);

    for (int i = 0; answer[i]; i++) {
        printf("%d ", answer[i]);
    }
}

int dfs(int x) {
    if (v[x].empty()) {
        answer[0]++;
        return 0;
    }

    int maxHeight = -1;
    for (int next : v[x]) {
        maxHeight = max(maxHeight, dfs(next));
    }
    if (x)
        answer[maxHeight + 1]++;
    return maxHeight + 1;
}

bool isOut(int x, int y) {
    return (x<1 || y<1 || x>n || y>m);
}