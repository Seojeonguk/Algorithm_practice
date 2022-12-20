#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll t, a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &t);

    while (t--) {
        scanf("%lld %lld", &a, &b);

        printf("%lld\n", a - b / 7 + b / 4);
    }
}