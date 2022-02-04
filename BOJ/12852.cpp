#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int visit[1000006], n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    queue<int> q;
    q.push(n);
    visit[n] = -1;

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        if (now == 1) {
            break;
        }

        if (now % 3 == 0 && !visit[now / 3]) {
            visit[now / 3] = now;
            q.push(now / 3);
        }

        if (now % 2 == 0 && !visit[now / 2]) {
            visit[now / 2] = now;
            q.push(now / 2);
        }

        if (!visit[now - 1]) {
            visit[now - 1] = now;
            q.push(now - 1);
        }
    }

    stack<int> s;
    int idx = 1;
    while (idx != -1) {
        s.push(idx);
        idx = visit[idx];
    }

    printf("%d\n", s.size() - 1);
    while (!s.empty()) {
        printf("%d ", s.top());
        s.pop();
    }
}