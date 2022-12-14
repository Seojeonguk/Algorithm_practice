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
bool isFinish[100002];
vector<int> zone[100002];
vector<vector<int> > scc;
stack<int> s;
int number[100002],sccnum[100002],indegree[100002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);
    for (int testCase = 0; testCase < tc; testCase++) {
        cnt = 0;
        memset(isFinish, false, sizeof isFinish);
        memset(number, 0, sizeof number);
        memset(sccnum, 0, sizeof sccnum);
        memset(indegree, 0, sizeof indegree);
        scc.clear();
        for (int i = 0; i < n; i++)
            zone[i].clear();

        scanf("%d %d", &n, &m);

        for (int i = 0; i < m; i++) {
            scanf("%d %d", &v, &w);
            zone[v].push_back(w);
        }

        for (int i = 0; i < n; i++)
            if (!number[i])
                dfs(i);

        for (int i = 0; i < n; i++)
            for (int next : zone[i]) {
                if (sccnum[i] != sccnum[next])
                    indegree[sccnum[next]]++;
            }

        vector<int> zeroIndegree;
        set<int> sccnumIdx;
        for (int i = 0; i < n; i++)
            if (!indegree[sccnum[i]]) {
                zeroIndegree.push_back(i);
                sccnumIdx.insert(sccnum[i]);
            }

        if (sccnumIdx.size() == 1) {
            for (int idx : zeroIndegree)
                printf("%d\n", idx);
        }
        else
            puts("Confused");
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