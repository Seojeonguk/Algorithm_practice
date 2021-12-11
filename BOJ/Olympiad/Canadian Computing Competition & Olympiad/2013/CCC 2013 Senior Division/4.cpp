#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, p, q;
bool visit[1000001];
vector<int> tall[1000001], small[1000001];

bool solve(int start, int destination,vector<int> v[1000001]) {
    queue<int> q;
    memset(visit, false, sizeof visit);

    visit[start] = true;
    q.push(start);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        if (now == destination)
            return true;

        int size = v[now].size();
        for (int i = 0; i < size; i++) {
            int next = v[now][i];
            if (visit[next]) continue;
            visit[next] = true;
            q.push(next);
        }
    }

    return false;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
        scanf("%d %d", &p, &q);
        tall[p].push_back(q);
        small[q].push_back(p);
    }

    scanf("%d %d", &p, &q);
    if (solve(p,q,tall)) puts("yes");
    else if (solve(p,q,small)) puts("no");
    else puts("unknown");
}