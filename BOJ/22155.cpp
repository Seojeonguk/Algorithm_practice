#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d", &a, &b);
        if ((a <= 2 && b <= 1) || (a <= 1 && b <= 2)) {
            puts("Yes");
        }
        else puts("No");
    }
}