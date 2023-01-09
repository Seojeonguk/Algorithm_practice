#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int st, ed, n, m, a, b;
vector<int> v[1002];
bool isVisit[1002];

int solve() {
    queue<pair<int, int> > q;
    q.push({ st,0 });
    isVisit[st] = true;

    while (!q.empty()) {
        auto now = q.front();
        q.pop();

        if (now.first == ed)
            return now.second;

        for (int i = 0; i < v[now.first].size(); i++) {
            int nextIdx = v[now.first][i];
            if (isVisit[nextIdx]) continue;
            isVisit[nextIdx] = true;
            q.push({ nextIdx,now.second + 1 });
        }
    }
    return -1;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &st, &ed);
    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    printf("%d\n", solve());
}
