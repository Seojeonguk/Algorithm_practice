#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, storeTime, breadTime, ans=1001;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d", &storeTime, &breadTime);
        if (storeTime > breadTime) {
            continue;
        }
        ans = min(ans, breadTime);
    }
    printf("%d\n", ans == 1001 ? -1 : ans);
}