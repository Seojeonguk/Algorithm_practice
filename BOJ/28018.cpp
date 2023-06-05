#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, q, s, e;
int sum[1000002],dp[1000002];


int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    while(n--) {
        scanf("%d %d", &s, &e);
        sum[s]++;
        sum[e+1]--;
    }


    for (int i = 1; i < 1000002; i++)
        dp[i] = dp[i - 1] + sum[i];

    scanf("%d", &n);
    while (n--) {
        scanf("%d", &q);
        printf("%d\n", dp[q]);
    }
}
