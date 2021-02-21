#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, x;
int arr[200005];
 
int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    sort(arr, arr + n);

    for (int i = 0; i < m; i++) {
        scanf("%d", &x);
        if (binary_search(arr, arr + n, x))
            printf("%d\n", lower_bound(arr, arr + n, x) - arr);
        else printf("-1\n");
    }
}