#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int x, y;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &x, &y);

    int a = 100 - x;
    int b = 100 - y;
    int c = 100 - (a + b);
    int d = a * b;
    int q = d / 100;
    int r = d % 100;

    printf("%d %d %d %d %d %d\n", a, b, c, d, q, r);
    printf("%d %d\n", c + q, r);
}