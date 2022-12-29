#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, a, b, c, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d %d", &a, &b, &c);

        int score = a * (b + c);
        if (a == b + c)
            score *= 2;

        ans = max(ans, score);
    }
    printf("%d\n", ans);
}