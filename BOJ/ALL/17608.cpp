#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, height, cnt, arr[100002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

    for (int i = n - 1; i >= 0; i--) {
        if (height < arr[i]) {
            height = arr[i];
            cnt++;
        }
    }
    printf("%d\n", cnt);
}