#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<ll, ll> a, b;
ll v, d, j;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &a.first, &a.second);
    scanf("%lld %lld", &b.first, &b.second);
    scanf("%lld %lld %lld", &v, &d, &j);

    printf("%lld\n", v * d * j * (a.first * a.second + b.first * b.second));
}