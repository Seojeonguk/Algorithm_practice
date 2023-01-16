#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n, m;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &n, &m);

    if (n == 1 || m == 1) printf("%lld\n", max(n, m));
    else  printf("%lld\n", 2 * n + 2 * m - 4);
}
