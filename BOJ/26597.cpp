#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, ans;
ll minValue = -1000000000000000000, maxValue = 1000000000000000000;
ll x;
char updown;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    for (int i = 1; i <= t; i++) {
        scanf("%lld %c", &x, &updown);
        if (updown == '^')
            minValue = max(minValue, x + 1);
        else
            maxValue = min(maxValue, x - 1);

        if (minValue > maxValue) {
            puts("Paradox!");
            printf("%d\n", i);
            return 0;
        }

        if (minValue == maxValue) {
            if (!ans)
                ans = i;
        }
    }
    if (ans) {
        puts("I got it!");
        printf("%d\n", ans);
    }
    else puts("Hmm...");
}