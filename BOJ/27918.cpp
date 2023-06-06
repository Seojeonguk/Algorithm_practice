#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, x, y;
char c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf(" %c", &c);
        if (c == 'D') x++;
        else y++;

        if (abs(x - y) == 2) break;
    }

    printf("%d:%d\n", x, y);
}