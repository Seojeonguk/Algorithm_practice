#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, l;
char tables[13][13];
set<string> s;
vector<string> v;
int X[] = { 1,0,-1, 0 }, Y[] = { 0,1,0,-1 };

bool isForbiddenAlphabet(char c) {
    return (c == 'a' || c == 'c' || c == 'm');
}

bool isOut(int x, int y) {
    return (x < 0 || y < 0 || x > n - 1 || y > m - 1);
}

void solve(int x, int y, string str) {
    if (str.size() == l) {
        s.insert(str);
        v.push_back(str);
        return;
    }

    for (int dir = 0; dir < 4; dir++) {
        int nextX = x + X[dir];
        int nextY = y + Y[dir];

        if (isOut(nextX, nextY) || isForbiddenAlphabet(tables[nextX][nextY])) continue;
        solve(nextX, nextY, str + tables[nextX][nextY]);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &l);

    for (int i = 0; i < n; i++)
        scanf("%s", &tables[i]);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!isForbiddenAlphabet(tables[i][j]))
                solve(i, j, string(1,tables[i][j]));
        }
    }

    printf("%zd\n%zd\n", v.size(), s.size());
}
