#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        if (!(i % 7) && !(i % 11)) puts("Wiwat!");
        else if (!(i % 7)) puts("Hurra!");
        else if (!(i % 11)) puts("Super!");
        else printf("%d\n", i);
    }
}
