#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int st, a, b, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (1) {
        scanf("%d %d %d %d", &st, &a, &b, &c);

        if (!st && !a && !b && !c) break;

        int wise = 0;

        wise += st - a + (st < a ? 40 : 0);
        wise += b - a + (b < a ? 40 : 0);
        wise += b - c + (b < c ? 40 : 0);

        printf("%d\n", 1080 + wise * 9);
    }
}
