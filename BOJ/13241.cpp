#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long int a, b;

long long int gcd(long long int x, long long int y) {
    if (y == 0) return x;
    return gcd(y, x % y);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld", &a, &b);

    printf("%lld", a * b / gcd(a, b));
}