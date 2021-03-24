#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

ll n, m;
//A^B กี A^(B mod phi(C) mod C
ll phi(ll x) {
    ll temp = x;
    ll prime = 2;
    while (prime * prime <= x) {
        if (x % prime == 0) temp -= temp / prime;
        while (x % prime == 0) x /= prime;
        prime++;
    }
    if (x != 1) temp -= temp / x;
    return temp;
}

ll pw(ll a, ll b, ll c) {
    ll ret = 1;
    while (b) {
        if (b%2) ret = ret * a % c;
        b /= 2;
        a = a * a % c;
    }
    return ret;
}

ll underfive(ll n, ll m) {
    if (n == 1) return 1;
    return pw(n, underfive(n - 1, m), m);
}

ll solve(ll a, ll b) {
    if (b == 1) return 1;
    if (a <= 5) return underfive(a, b);
    return pw(a, solve(a - 1, phi(b)) + phi(b), b);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &n, &m);
    printf("%lld\n", solve(n, m) % m);
}