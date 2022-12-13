#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int subjectCnt, subject[1002], prerequisite[1002];
int conditionCnt, a, b;
vector<int> v[1002];
queue<int> q;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &subjectCnt, &conditionCnt);
    for (int condition = 0; condition < conditionCnt; condition++) {
        scanf("%d %d", &a, &b);

        prerequisite[b]++;
        v[a].push_back(b);
    }

    for (int idx = 1; idx <= subjectCnt; idx++) {
        if (!prerequisite[idx]) {
            subject[idx] = 1;
            q.push(idx);
        }
    }

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : v[now]) {
            prerequisite[next]--;
            if (!prerequisite[next]) {
                subject[next] = subject[now] + 1;
                q.push(next);
            }
        }
    }

    for (int idx = 1; idx <= subjectCnt; idx++) {
        printf("%d ", subject[idx]);
    }
}