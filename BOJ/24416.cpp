#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n,dp[42];

int solve(int x) {
    int& ret = dp[x];
    if (x == 1 || x == 2)
        return 1;
    if (ret != 0)
        return ret;

    return ret = solve(x - 1) + solve(x - 2);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    solve(n);

    printf("%d %d\n", dp[n], n-2);
}