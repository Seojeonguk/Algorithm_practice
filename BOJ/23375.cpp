#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll x, y, r;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld %lld", &x, &y, &r);

    printf("%lld %lld\n", x - r, y - r);
    printf("%lld %lld\n", x - r, y + r);
    printf("%lld %lld\n", x + r, y + r);
    printf("%lld %lld\n", x + r, y - r);
}