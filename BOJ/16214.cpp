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
        if (b % 2) ret = ret * a % c;
        b /= 2;
        a = a * a % c;
    }
    return ret;
}


ll solve(ll a, ll b) {
    if (b == 1) return 1;
    return pw(a, solve(a, phi(b)) + phi(b), b);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    int t;
    scanf("%d", &t);
    while (t--) {
        scanf("%lld %lld", &n, &m);
        printf("%lld\n", solve(n, m) % m);
    }
}