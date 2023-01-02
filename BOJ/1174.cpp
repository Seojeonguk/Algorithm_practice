#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n;
vector<ll> v;

void solve(ll x) {
    v.push_back(x);
    for (ll i = 0; i < x % 10; i++) {
        solve(x * 10 + i);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);
    for (ll i = 0; i < 10; i++)
        solve(i);

    sort(v.begin(), v.end());

    ll ans = -1;
    if(v.size() >= n)
        ans = v[n-1];
    printf("%lld\n", ans);
}
