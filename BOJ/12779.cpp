#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll a, b, cnt, i = 1;

ll GCD(ll a, ll b) {
	return b ? GCD(b, a % b) : a;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &a, &b);
    
    while (i * i <= b) {
        if (i * i > a) cnt++;
        i++;
    }

    ll G = GCD(cnt, b - a);
    ll up = cnt / G;
    ll down = (b - a) / G;

    if (!up) puts("0");
    else printf("%lld/%lld\n", up, down);
}
