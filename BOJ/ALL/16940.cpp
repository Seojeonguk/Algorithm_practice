#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, a, b;
vector<int> v[100002];
queue<int> order,q;
bool visit[100004];

int solve() {
    q.push(1);
    visit[1] = true;

    while (!q.empty()) {
        int outidx = q.front();
        q.pop();

        set<int> s;
        int size = v[outidx].size();
        for (int i = 0; i < size; i++) {
            int next_idx = v[outidx][i];
            if (visit[next_idx]) continue;
            visit[next_idx] = true;
            s.insert(next_idx);
        }

        size = s.size();
        for (int i = 0; i < size; i++) {
            int order_first = order.front();
            order.pop();

            if (s.find(order_first) == s.end()) return 0;
            q.push(order_first);
        }
    }
    return 1;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    for (int i = 0; i < n - 1; i++) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for (int i = 0; i < n; i++) {
        scanf("%d", &a);
        order.push(a);
    }

    int first = order.front();
    order.pop();
    if (first != 1) puts("0");
    else printf("%d\n", solve());
}