#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
pair<int, int> counselings[1500001];
int dp[1500001];

int solve(int idx) {
    if (idx == n) return 0;
    if (idx > n) return -1500000000;
    int& ret = dp[idx];
    if (ret != -1) return ret;
    ret = 0;

    ret = max(ret, solve(idx + 1));
    ret = max(ret, solve(idx + counselings[idx].first) + counselings[idx].second);

    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    memset(dp, -1, sizeof dp);

    for (int i = 0; i < n; i++)
        scanf("%d %d", &counselings[i].first, &counselings[i].second);

    solve(0);

    printf("%d\n", dp[0]);
}
