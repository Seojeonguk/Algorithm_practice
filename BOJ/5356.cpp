#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
char c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %c", &n, &c);

        for (int i = 0; i < n; i++) {
            char q = (c + i - 'A') % 26 + 'A';
            for (int j = 0; j <= i; j++)
                printf("%c", q);
            puts("");
        }
        puts("");
    }
}
