#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int dfs(int);
int n, m, cnt, v, w;
bool isFinish[200002];
vector<int> flight[200002];
vector<vector<int> > scc;
stack<int> s;
int number[200002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &v, &w);
        flight[v].push_back(w);
    }

    for (int i = 1; i <= n; i++)
        if (!number[i])
            dfs(i);

    printf("%s", scc.size() == 1 ? "Yes" : "No");
}

int dfs(int idx) {
    int ret = number[idx] = ++cnt;
    s.push(idx);

    for (int next : flight[idx]) {
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
            if (top == idx) break;
        }
        scc.push_back(tmp);
    }
    return ret;
}