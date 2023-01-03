#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, cnt;

int solve(int x) {
    int ret = 1;
    while (x) {
        ret *= x % 10;
        x /= 10;
    }
    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    while (1) {
        if (n < 10) break;
        n= solve(n);
        cnt++;
    }
    printf("%d\n", cnt);
}
