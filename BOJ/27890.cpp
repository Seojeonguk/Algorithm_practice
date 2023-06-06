#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int x, n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &x, &n);

    for (int i = 1; i <= n; i++) {
        if (x & 1) x = (2 * x) ^ 6;
        else x = (x / 2) ^ 6;
    }

    printf("%d\n", x);
}