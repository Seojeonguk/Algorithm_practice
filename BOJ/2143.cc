#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, m;
int a[1002], b[1002];
vector<int> aSum, bSum;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += a[j];
            aSum.push_back(sum);
        }
    }

    scanf("%d", &m);
    for (int i = 0; i < m; i++) 
        scanf("%d", &b[i]);

    for (int i = 0; i < m; i++) {
        int sum = 0;
        for (int j = i; j < m; j++) {
            sum += b[j];
            bSum.push_back(sum);
        }
    }

    sort(bSum.begin(), bSum.end());

    ll ans = 0;
    for (int sum : aSum) {
        int x = t - sum;
        auto up = upper_bound(bSum.begin(), bSum.end(), x);
        auto lo = lower_bound(bSum.begin(), bSum.end(), x);
        ans += up - lo;
    }
    printf("%lld\n", ans);
}