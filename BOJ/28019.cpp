#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll ans, max_distance;
int n, m, a, b, c, s;
vector<pair<int, int> > v[50002];
bool visit[50002];
vector<pair<int,int> > selected[500002];
priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<> > pq;

void dfs(int idx, ll sum) {
    max_distance = max(max_distance, sum);
    for (pair<int, int> next : selected[idx]) {
        if (visit[next.first]) continue;
        visit[next.first] = true;
        dfs(next.first, sum + next.second);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    while (m--) {
        scanf("%d %d %d\n", &a, &b, &c);
        v[a].push_back({ b,c });
        v[b].push_back({ a,c });
    }
    scanf("%d", &s);

    pq.push({ 0,{s,s} });
    while (!pq.empty()) {
        int now_cost = -pq.top().first;
        int now_idx = pq.top().second.first;
        int prev_idx = pq.top().second.second;
        pq.pop();

        if (visit[now_idx]) continue;
        visit[now_idx] = true;
        if (prev_idx != now_idx) {
            selected[prev_idx].push_back({ now_idx,now_cost });
            selected[now_idx].push_back({ prev_idx,now_cost });
        }
        ans += now_cost;
        n--;
        if (!n) break;
        for (pair<int, int> next : v[now_idx]) {
            if (visit[next.first]) continue;
            pq.push({ -next.second, {next.first,now_idx} });
        }
    }


    memset(visit, false, sizeof visit);
    visit[s] = true;

    dfs(s, 0);

    printf("%lld\n", ans * 2LL - max_distance);
}
