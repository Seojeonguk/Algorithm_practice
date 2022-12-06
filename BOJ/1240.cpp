#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

vector<pair<int,int> > tree[1001];
int nodeCnt, queryCnt;
int nodeA, nodeB, dist;
bool visit[1001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &nodeCnt, &queryCnt);
    for (int i = 0; i < nodeCnt - 1; i++) {
        scanf("%d %d %d", &nodeA, &nodeB, &dist);
        tree[nodeA].push_back({ nodeB,dist });
        tree[nodeB].push_back({ nodeA,dist });
    }

    for (int query = 0; query < queryCnt; query++) {
        scanf("%d %d", &nodeA, &nodeB);
        memset(visit, false, sizeof visit);
        priority_queue<pair<int, int> > pq;
        pq.push({ 0,nodeA });
        while (!pq.empty()) {
            auto data = pq.top();
            pq.pop();

            if (data.second == nodeB) {
                printf("%d\n", data.first);
                break;
            }

            for (int idx = 0; idx < tree[data.second].size(); idx++) {
                int nextNode = tree[data.second][idx].first;
                int nextDist = tree[data.second][idx].second;

                if (visit[nextNode]) {
                    continue;
                }
                visit[nextNode] = true;
                pq.push({ data.first + nextDist,nextNode });
            }
        }
    }
}