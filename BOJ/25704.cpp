#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, p, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &p);
    ans = p;
    if (n >= 5)
        ans = min(ans, max(p - 500, 0));
    if (n >= 10)
        ans = min(ans, p / 100 * 90);
    if (n >= 15)
        ans = min(ans, max(p - 2000, 0));
    if (n >= 20)
        ans = min(ans, p / 100 * 75);

    printf("%d\n", ans);
}