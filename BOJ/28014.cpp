#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans, h, prev_h;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    while (n--) {
        scanf("%d", &h);
        if (prev_h <= h) {
            ans++;
        }
        prev_h = h;
    }

    printf("%d\n", ans);
}
