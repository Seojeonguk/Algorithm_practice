#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (1) {
        scanf("%d %d", &a, &b);

        if (!a && !b) break;

        int c = a - b;
        int three = 0;
        if (c >= 3 && c % 2) {
            three = 1;
            c -= 3;
        }

        printf("%d %d\n", c / 2, three);
    }
}
