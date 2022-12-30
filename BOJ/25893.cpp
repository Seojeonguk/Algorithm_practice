#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, a[3];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d %d", &a[0], &a[1], &a[2]);

        printf("%d %d %d\n", a[0], a[1], a[2]);

        sort(a, a + 3);

        if (a[0] >= 10) puts("triple-double");
        else if (a[1] >= 10) puts("double-double");
        else if (a[2] >= 10) puts("double");
        else puts("zilch");
        puts("");
    }
}
