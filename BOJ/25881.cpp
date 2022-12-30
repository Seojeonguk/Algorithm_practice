#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b, t, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &a, &b);
    scanf("%d", &t);

    while (t--) {
        scanf("%d", &c);

        printf("%d %d\n", c, min(1000, c) * a + max(0, c - 1000) * b);
    }
}
