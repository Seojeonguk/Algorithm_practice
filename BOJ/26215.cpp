#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int solve();
int n,x;
priority_queue<int> pq;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        pq.push(x);
    }

    printf("%d\n", solve());
}

int solve() {
    int time = 0;

    while (!pq.empty() && time <= 1440) {
        int next = pq.top();
        pq.pop();
        int nextnext = -1;
        if (!pq.empty()) {
            nextnext = pq.top();
            pq.pop();
        }
        if (next - 1) {
            pq.push(next - 1);
        }
        if (nextnext != -1 && nextnext - 1 != 0) {
            pq.push(nextnext - 1);
        }
        time++;
    }

    return time > 1440 ? -1 : time;
}