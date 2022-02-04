#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, c,ei,b1,b2;
vector<int> v[100001];
int cost[100001];
queue<int> q;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &c);

    for (int i = 0; i < c; i++) {
        scanf("%d %d %d", &ei, &b1, &b2);
        v[ei].push_back(b1);
        v[ei].push_back(b2);
    }

    cost[1] = 1;
    q.push(1);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int i = 0; i < v[now].size(); i++) {
            int next = v[now][i];

            if (cost[next]) continue;

            cost[next] = cost[now] + 1;
            q.push(next);
        }
    }

    for (int i = 1; i <= n; i++)
        printf("%d\n", cost[i]);
}