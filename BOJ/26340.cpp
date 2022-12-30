#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, a, b, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d %d", &a, &b, &c);
        printf("Data set: %d %d %d\n", a, b, c);

        for (int i = 0; i < c; i++) {
            if (a > b) a /= 2;
            else b /= 2;
        }

        printf("%d %d\n\n", max(a, b), min(a, b));
    }
}
