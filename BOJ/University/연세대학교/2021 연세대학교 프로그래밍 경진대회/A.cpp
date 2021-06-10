#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n = 9,sum,x;
bool hack;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        if (x > (i/2+1) * 100) {
            hack = true;
            puts("hacker");
            return 0;
        }
        sum += x;
    }
    if (sum >= 100) puts("draw");
    else puts("none");
}