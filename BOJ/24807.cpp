#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b, c, l;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &a, &b, &c, &l);

    bool isFind = false;
    for (int i = 0; i <= l / a; i++) {
        for (int j = 0; j <= l / b; j++) {
            int sum = a * i + b * j;
            if (sum > l) break;
            int r = l - sum;
            if (r % c == 0) {
                isFind = true;
                printf("%d %d %d\n", i, j, r / c);
            }
        }
    }

    if (!isFind) puts("impossible");
}