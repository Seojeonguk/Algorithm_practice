#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k;
int visit[500002][2];
bool isOut(int x) { return x < 0 || x>500000; }
int dir[3] = { 1,-1,0 };

int solve() {
    for (int i = 0; i < 500002; i++) {
        int idx = k + ((i + 1) * i) / 2;
        if (idx > 500000) break;

        if (visit[idx][i % 2] != -1 && visit[idx][i % 2] <= i) {
            return i;
        }
    }
    return -1;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &k);

    memset(visit, -1, sizeof visit);
    queue<pair<int, int> > q;
    visit[n][0] = 0;
    q.push({ n,0 });

    while (!q.empty()) {
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();

        dir[2] = cur;
        for (int i = 0; i < 3; i++) {
            int next = cur + dir[i];
            if (isOut(next) || visit[next][(cnt + 1) % 2] !=-1) continue;
            visit[next][(cnt + 1) % 2] = cnt + 1;
            q.push({ next,cnt + 1 });
        }
    }

    printf("%d\n", solve());
}
