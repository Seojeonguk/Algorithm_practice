#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k, cnt, ans;
int arr[500002], sorted[500002];

void merge(int* a, int s, int m, int e) {
    int i = s;
    int j = m + 1;
    int t = 1;
    while (i <= m && j <= e) {
        if (a[i] <= a[j])
            sorted[t++] = a[i++];
        else
            sorted[t++] = a[j++];
    }

    while (i <= m) {
        sorted[t++] = a[i++];
    }
    while (j <= e) {
        sorted[t++] = a[j++];
    }
    i = s;
    t = 1;
    while (i <= e) {
        a[i++] = sorted[t++];
        cnt++;
        if (cnt == k)
            ans = a[i - 1];
    }
}

void mergeSort(int* a, int s, int e) {
    if (s < e) {
        int m = (s + e) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m + 1, e);
        merge(a, s, m, e);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &k);

    for (int idx = 0; idx < n; idx++)
        scanf("%d", &arr[idx]);

    mergeSort(arr, 0, n - 1);

    printf("%d\n", cnt >= k ? ans : -1);
}