#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;

int t, n;
int mexinos[13][13];
vector<pair<int,pair<int, int> > > v;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int maxConnectedCnt, minWiresLength;

bool isEdge(int x, int y) {
    return (x == 0 || y == 0 || x == n - 1 || y == n - 1);
}

bool isConnect(int x, int y, int d) {
    while (!isEdge(x, y)) {
        x += X[d];
        y += Y[d];
        if(mexinos[x][y])
            return false;
    }

    return true;
}

int connectWire(int x, int y, int d, int v) {
    int wireLength = 0;
    while (!isEdge(x, y)) {
        x += X[d];
        y += Y[d];
        mexinos[x][y] = v;
        wireLength++;
    }
    return wireLength;
}

void dfs(int cnt, int connectedCnt, int wiresLength) {
    if (cnt == -1) {
        if (maxConnectedCnt < connectedCnt) {
            maxConnectedCnt = connectedCnt;
            minWiresLength = wiresLength;
        }
        else if (maxConnectedCnt == connectedCnt) {
            minWiresLength = min(minWiresLength, wiresLength);
        }
        return;
    }

    bool isConnecting = true;

    for (int dir = 0; dir < 4; dir++) {
        int x = v[cnt].second.first;
        int y = v[cnt].second.second;
        if (isConnect(x, y, dir)) {
            isConnecting = false;
            int wireLength = connectWire(x, y, dir, 1);
            dfs(cnt - 1, connectedCnt + 1, wiresLength + wireLength);
            connectWire(x, y, dir, 0);
        }
    }

    if (isConnecting)
        dfs(cnt - 1, connectedCnt, wiresLength);
}

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        maxConnectedCnt = minWiresLength = 0;
        v.clear();
        scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &mexinos[i][j]);
                if (mexinos[i][j] && !isEdge(i, j)) {
                    int shortestPath = min(i, min(j, min(n - 1 - i, n - 1 - j)));

                    v.push_back({ shortestPath,{ i,j } });
                }
                    
            }
        }

        sort(v.begin(), v.end());

        dfs(v.size()-1, 0, 0);

        printf("#%d %d\n", tc, minWiresLength);
    }
}
