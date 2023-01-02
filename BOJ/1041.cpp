#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n;
ll ans, arr[6];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);

    for (int i = 0; i < 6; i++)
        scanf("%lld", &arr[i]);

    if (n == 1) {
        sort(arr, arr + 6);
        for (int i = 0; i < 5; i++)
            ans += arr[i];
        printf("%lld\n", ans);
        return 0;
    }
    ll minValue = INT64_MAX;
    for (int i = 0; i < 6; i++)
        minValue = min(minValue, arr[i]);
    ans += minValue * (n - 2LL) * (5LL * n - 6LL);

    minValue = INT64_MAX;
    for (int i = 0; i < 6; i++) {
        for (int j = i+1; j < 6; j++) {
            if (i + j == 5)
                continue;
            minValue = min(minValue, arr[i] + arr[j]);
        }
    }
    ans += minValue * 4 * (2LL * n - 3LL);
    

    minValue = INT64_MAX;
    for (int i = 0; i < 6; i++) {
        for (int j = i + 1; j < 6; j++) {
            for (int k = j + 1; k < 6; k++) {
                if ((5 - k == i) || (5 - k == j) || (5 - j == i)) {
                    continue;
                }
                minValue = min(minValue, arr[i] + arr[j] + arr[k]);
            }
        }
    }
    ans += minValue * 4LL;
    
    printf("%lld\n", ans);
}
