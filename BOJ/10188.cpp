#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc, r, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    while (tc--) {
        scanf("%d %d", &c, &r);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                printf("X");
            puts("");
        }
        puts("");
    }
}