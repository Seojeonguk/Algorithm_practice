#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k,first,second;
bool visit[252];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &k);

    vector<int> v[252];
    memset(visit, false, sizeof visit);

    for (int i = 0; i < k; i++) {
        scanf("%d %d", &first, &second);
        v[first].push_back(second);
        v[second].push_back(first);
    }

    queue<int> q;
    q.push(1);
    visit[1] = true;

    while (!q.empty()) {
        int outdata = q.front();
        q.pop();

        for (int i = 0; i < v[outdata].size(); i++) {
            if (!visit[v[outdata][i]]) {
                visit[v[outdata][i]] = true;
                q.push(v[outdata][i]);
            }
        }
    }

    vector<int> misbehavingcows;
    for (int i = 1; i <= n; i++)
        if (!visit[i])
            misbehavingcows.push_back(i);

    if (!misbehavingcows.empty()) {
        for (int i = 0; i < misbehavingcows.size(); i++)
            printf("%d\n", misbehavingcows[i]);
    }
    else {
        puts("0");
    }
}