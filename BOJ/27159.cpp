#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[35];
int value, cnt, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        if (value + cnt != arr[i]) {
            value = arr[i];
            cnt = 1;
            ans += value;
        }
        else cnt++;
    }
    printf("%d\n", ans);
}
