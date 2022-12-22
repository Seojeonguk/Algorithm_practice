#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int m, s, g, l, r;
double a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %lf%lf %d %d", &m, &s, &g, &a, &b, &l, &r);

    double left = 1.0 * l / a + (1.0 * m / g);
    double right = 1.0 * r / b + (1.0 * m / s);

    puts(left > right ? "latmask" : "friskus");
}