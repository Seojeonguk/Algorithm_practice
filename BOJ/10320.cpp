#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc, n, t;
int btns[17];
bool isVisit[3601];

pair<int, int> solve() {
    int minTime = 3601;
    int minBtnCnt = 3601;
    queue<pair<int, int> > q;
    isVisit[0] = true;
    q.push({ 0,0 });

    while (!q.empty()) {
        auto now = q.front();
        q.pop();

        if (now.first == t)
            return { now.second,0 };

        if (now.first > t) {
            if (minTime - t > now.first - t) {
                minTime = now.first;
                minBtnCnt = now.second;
            }
            else if (minTime - t == now.first - t) {
                minBtnCnt = min(minBtnCnt, now.second);
            }
        }

        for (int i = 0; i < n; i++) {
            int nextTime = now.first + btns[i];
            if (nextTime < 0) nextTime = 0;
            if (nextTime > 3600) nextTime = 3600;
            if (isVisit[nextTime]) continue;

            isVisit[nextTime] = true;
            q.push({ nextTime, now.second + 1 });
        }
    }
    return { minBtnCnt, minTime - t };
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    while (tc--) {
        memset(isVisit, false, sizeof isVisit);
        scanf("%d %d", &n, &t);

        for (int i = 0; i < n; i++)
            scanf("%d", &btns[i]);

        pair<int, int> ans = solve();

        printf("%d %d\n", ans.first, ans.second);
    }
}
