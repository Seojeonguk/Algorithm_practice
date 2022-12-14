#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int dfs(int);
int tc, n, m, cnt, v, w;
bool isFinish[5002];
vector<int> zone[5002];
vector<vector<int> > scc;
stack<int> s;
int number[5002],sccnum[5002],outdegree[5002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while(scanf("%d",&n) && n!=0) {
        cnt = 0;
        memset(isFinish, false, sizeof isFinish);
        memset(number, 0, sizeof number);
        memset(sccnum, 0, sizeof sccnum);
        memset(outdegree, 0, sizeof outdegree);
        scc.clear();
        for (int i = 1; i <= n; i++)
            zone[i].clear();

        scanf("%d", &m);

        for (int i = 0; i < m; i++) {
            scanf("%d %d", &v, &w);
            zone[v].push_back(w);
        }

        for (int i = 1; i <= n; i++)
            if (!number[i])
                dfs(i);

        for (int i = 1; i <= n; i++)
            for (int next : zone[i]) {
                if (sccnum[i] != sccnum[next])
                    outdegree[sccnum[i]]++;
            }

        for (int i = 1; i <= n; i++)
            if (!outdegree[sccnum[i]])
                printf("%d ", i);
        puts("");
    }
}

int dfs(int idx) {
    int ret = number[idx] = ++cnt;
    s.push(idx);

    for (int next : zone[idx]) {
        if (!number[next])
            ret = min(ret, dfs(next));
        else if (!isFinish[next])
            ret = min(ret, number[next]);
    }

    if (ret == number[idx]) {
        vector<int> tmp;
        while (!s.empty()) {
            int top = s.top();
            s.pop();

            tmp.push_back(top);
            isFinish[top] = true;
            sccnum[top] = scc.size() + 1;
            if (top == idx) break;
        }
        scc.push_back(tmp);
    }
    return ret;
}