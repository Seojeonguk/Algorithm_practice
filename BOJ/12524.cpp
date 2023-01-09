#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, x;
vector<int> v[1002];
bool isVisit[1002];

int solve(int st) {
    memset(isVisit, false, sizeof isVisit);
    int cnt = 0;
    
    queue<int> q;
    isVisit[st] = true;
    q.push(st);
    

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        cnt++;

        for (int i = 0; i < v[now].size(); i++) {
            if (isVisit[v[now][i]]) continue;
            isVisit[v[now][i]] = true;
            q.push(v[now][i]);
        }
    }

    return cnt;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d", &n);

        for (int i = 1; i <= n; i++)
            v[i].clear();

        for (int i = 1; i <= n; i++) {
            scanf("%d", &x);
            v[x].push_back(i);
        }

        printf("Case #%d:\n", tc);
        for (int i = 1; i <= n; i++) {
            printf("%d\n", solve(i));
        }
    }
}
