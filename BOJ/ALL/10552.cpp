#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, p;
pair<int, int> pensioner[100005];
int changes[100005];
bool visit[100005];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &m, &p);

    for (int i = 0; i < n; i++) {
        scanf("%d %d", &pensioner[i].first, &pensioner[i].second);
        if (!changes[pensioner[i].second])
            changes[pensioner[i].second] = pensioner[i].first;
    }

    int ans = 0;
    while (true) {
        if (!changes[p]) break;
        if (visit[p]) {
            ans = -1;
            break;
        }

        ans++;
        visit[p] = true;
        p = changes[p];
    }
    printf("%d\n", ans);
}