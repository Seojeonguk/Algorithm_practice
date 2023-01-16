#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b, c, d;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &a, &b, &c, &d);

    if (a * b > c * d) puts("M");
    else if (a * b < c * d) puts("P");
    else puts("E");
}
