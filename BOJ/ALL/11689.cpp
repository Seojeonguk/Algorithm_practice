#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

ll n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);

    ll temp = n;
    ll prime = 2;
    while (prime * prime <= n) {
        if (n % prime == 0) temp -= temp / prime;
        while (n % prime == 0) n /= prime;
        prime++;
    }
    if (n != 1) temp -= temp / n;
    printf("%lld\n", temp);
}