#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll w, h, f, c, stX, stY, endX, endY, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld %lld %lld", &w, &h, &f, &c);
    scanf("%lld %lld %lld %lld", &stX, &stY, &endX, &endY);

    ans = w * h;

    ll x = min(f, w - f);

    ll g = (endY - stY) * (min(endX,x) - stX) * (c + 1) * 2;
    if(g>0)
        ans -= g;
    
    ll h = (endY - stY) * (endX - max(x, stX)) * (c + 1);
    if(h>0)
        ans -= h;

    printf("%lld\n",ans);
}
