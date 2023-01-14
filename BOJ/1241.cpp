#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[100001], cnt[1000001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        cnt[arr[i]]++;
    }

    for (int i = 0; i < n; i++) {
        int sq = sqrt(arr[i]);
        int ans = 0;
        for (int j = 1; j <= sq; j++) {
            if (arr[i] % j) continue;
            ans += cnt[j];
            if (j * j != arr[i])
                ans += cnt[arr[i] / j];
        }

        printf("%d\n", ans - 1);
    }
}
