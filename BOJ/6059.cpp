#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int calCost();
int cowCnt, queryCnt, a, b, cost;
vector<pair<int, int> > v[1002];
bool isVisit[1002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &cowCnt, &queryCnt);

    for (int i = 0; i < cowCnt - 1; i++) {
        scanf("%d %d %d", &a, &b, &cost);
        v[a].push_back({ b,cost });
        v[b].push_back({ a,cost });
    }

    for (int i = 0; i < queryCnt; i++) {
        scanf("%d %d", &a, &b);
        printf("%d\n", calCost());
    }
}

int calCost() {
    memset(isVisit, false, sizeof isVisit);
    priority_queue<pair<int, int> > pq;
    pq.push({ 0,a });
    isVisit[a] = true;

    while (!pq.empty()) {
        auto now = pq.top();
        pq.pop();

        if (now.second == b) {
            return now.first;
        }

        int nextSize = v[now.second].size();

        for (int idx = 0; idx < nextSize; idx++) {
            int nextIdx = v[now.second][idx].first;
            int nextCost = v[now.second][idx].second;

            if (isVisit[nextIdx]) {
                continue;
            }
            isVisit[nextIdx] = true;
            pq.push({ now.first + nextCost,nextIdx });
        }
    }
    return 0;
}