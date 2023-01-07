#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int ans, a[10];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 10; i++)
        scanf("%d", &a[i]);

    for (int i = 0; i < 10; i++)
        for (int j = i + 1; j < 10; j++)
            ans ^= (a[i] || a[j]);

    for (int i = 0; i < 10; i++)
        for (int j = i + 1; j < 10; j++)
            for (int k = j + 1; k < 10; k++)
                ans ^= (a[i] || a[j] || a[k]);

    printf("%d\n", ans);
}
