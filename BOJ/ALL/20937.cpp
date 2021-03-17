#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,ans, arr[500003],high[500003];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        high[arr[i]]++;
    }

    sort(arr, arr + n, greater<int>());

    for (int i = 0; i < n; i++)
        ans += (high[arr[i]] >= ans ? high[arr[i]] - ans : 0);

    printf("%d\n", ans);
}