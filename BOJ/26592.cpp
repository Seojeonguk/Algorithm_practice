#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
double area, base;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%lf %lf", &area, &base);

        printf("The height of the triangle is %.2lf units\n", area * 2.0 / base);
    }
}