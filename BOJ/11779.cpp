#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int cityCnt, busCnt;
int startCity, destinationCity, cost;
vector<pair<int, int> > v[1002];
int dist[1002], parent[1002];
priority_queue<pair<int, int> > pq;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &cityCnt, &busCnt);
    
    for (int idx = 0; idx <= cityCnt; idx++) {
        dist[idx] = INT32_MAX;
    }

    for (int bus = 0; bus < busCnt; bus++) {
        scanf("%d %d %d", &startCity, &destinationCity, &cost);
        v[startCity].push_back({ destinationCity,cost });
    }
    scanf("%d %d", &startCity, &destinationCity);

    for (int idx = 1; idx <= startCity; idx++) {
        sort(v[idx].begin(), v[idx].end());
    }

    pq.push({ 0,startCity });
    dist[startCity] = 0;

    while (!pq.empty()) {
        pair<int, int> now = pq.top();
        pq.pop();

        for (pair<int,int> next : v[now.second]) {
            int nextCost = -now.first + next.second;
            int nextIdx = next.first;
            
            if (dist[nextIdx] > nextCost) {
                dist[nextIdx] = nextCost;
                parent[nextIdx] = now.second;
                pq.push({ -nextCost,nextIdx });
            }
        }
    }
    deque<int> path;
    int idx = destinationCity;
    while (idx) {
        path.push_front(idx);
        idx = parent[idx];
    }

    printf("%d\n%d\n", dist[destinationCity], path.size());
    for (int idx : path) {
        printf("%d ", idx);
    }
}