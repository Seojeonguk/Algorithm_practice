#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, k,first,second;
bool visit[101];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int tc = 0; tc < t; tc++) {
        scanf("%d %d", &n, &k);

        vector<int> v[101];
        memset(visit, false, sizeof visit);

        for (int i = 0; i < k; i++) {
            scanf("%d %d", &first, &second);
            v[first].push_back(second);
            v[second].push_back(first);
        }

        queue<int> q;
        q.push(0);
        visit[0] = true;

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

        bool connect = true;
        for (int i = 0; i < n; i++)
            if (!visit[i])
                connect = false;

        if (connect) puts("Connected.");
        else puts("Not connected.");
    }
}