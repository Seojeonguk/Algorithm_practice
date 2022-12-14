#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int dfs(int);
int vCnt, eCnt, a, b, tc, cnt, ans;
vector<int> v[100002];
bool isFinish[100002];
vector<vector<int> > SCC;
int number[100002], indegree[100002], sccnum[100002];
stack<int> s;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);
    for (int testCase = 0; testCase < tc; testCase++) {
        memset(indegree, 0, sizeof indegree);
        memset(number, 0, sizeof number);
        memset(isFinish, false, sizeof isFinish);
        ans = cnt = 0;
        SCC.clear();
        for (int idx = 1; idx <= vCnt; idx++) {
            v[idx].clear();
        }

        scanf("%d %d", &vCnt, &eCnt);
        for (int i = 0; i < eCnt; i++) {
            scanf("%d %d", &a, &b);
            v[a].push_back(b);
        }

        for (int idx = 1; idx <= vCnt; idx++)
            if (!number[idx])
                dfs(idx);

        for (int idx = 1; idx <= vCnt; idx++)
            for (int next : v[idx])
                if (sccnum[idx] != sccnum[next])
                    indegree[sccnum[next]]++;

        for (int idx = 1; idx <= SCC.size(); idx++)
            if (!indegree[idx])
                ans++;

        printf("%d\n", ans);
    }
}

int dfs(int idx) {
    number[idx] = ++cnt;

    int ret = number[idx];
    s.push(idx);

    for (int next : v[idx]) {
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
            sccnum[top] = SCC.size()+1;
            if (top == idx)
                break;
        }
        SCC.push_back(tmp);
    }

    return ret;
}