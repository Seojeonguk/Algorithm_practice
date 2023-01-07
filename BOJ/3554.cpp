#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, arr[50002];
int l, r, k;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        scanf("%d", &arr[i]);

    scanf("%d", &m);

    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &k, &l, &r);
        if (k == 1) {
            for (int i = l; i <= r; i++)
                arr[i] = (arr[i] * arr[i]) % 2010;
        }
        else {
            int sum = 0;
            for (int i = l; i <= r; i++)
                sum += arr[i];
            printf("%d\n", sum);
        }
    }
}
