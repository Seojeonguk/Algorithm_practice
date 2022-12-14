#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int dfs(int);
int vCnt, eCnt, a, b;
vector<int> v[10002];
bool isFinish[10002];
vector<vector<int> > SCC;
int number[10002], cnt;
stack<int> s;

bool cmp(vector<int>& a, vector<int>& b) {
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    return a[0] < b[0];
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &vCnt, &eCnt);

    for (int i = 0; i < eCnt; i++) {
        scanf("%d %d", &a, &b);
        v[a].push_back(b);
    }

    for (int v = 1; v <= vCnt; v++) {
        if (!number[v]) {
            dfs(v);
        }
    }

    sort(SCC.begin(), SCC.end(),cmp);

    printf("%d\n", SCC.size());
    for (vector<int> next : SCC) {
        
        for (int nextIdx : next) {
            printf("%d ", nextIdx);
        }
        printf("-1\n");
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
            if (top == idx)
                break;
        }
        SCC.push_back(tmp);
    }

    return ret;
}