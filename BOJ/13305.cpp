#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, minCost, idx, ans;
ll roads[100001], costs[100001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);

    for (int i = 0; i < n - 1; i++)
        scanf("%lld", &roads[i]);

    for (int i = 0; i < n; i++) {
        scanf("%lld", &costs[i]);
    }

    costs[n - 1] = 0;
    minCost = INT64_MAX;

    for (int i = 0; i < n; i++) {
        if (minCost > costs[i]) {

            ll roadSum = 0;
            for (int j = idx; j < i; j++) {
                roadSum += roads[j];
            }
            ans += roadSum * minCost;
            idx = i;
            minCost = costs[i];
        }
    }
    printf("%lld\n", ans);
}