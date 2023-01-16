#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll k;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &k);

    while (!(k % 10)) {
        k /= 10;
    }

    int ans = 0;
    while (k) {
        if (k % 10 == 0) ans++;
        k /= 10;
    }
    printf("%d\n", ans);
}
