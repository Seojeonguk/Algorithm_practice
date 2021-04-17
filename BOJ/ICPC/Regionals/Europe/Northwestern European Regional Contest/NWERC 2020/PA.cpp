#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll a;
double pi = 3.1415926535897932;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &a);
    double square_r = a / pi;
    double r = sqrt(square_r);

    printf("%lf", 2 * pi * r);
}