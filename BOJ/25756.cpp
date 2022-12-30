#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, potion;
double beforeDependRate, dependRate;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d", &potion);
        beforeDependRate = dependRate;
        double v = 1.0 - beforeDependRate;
        double a = 1.0 - potion / 100.0;
        dependRate = 1.0 - v * a;
        printf("%lf\n", dependRate * 100.0);
    }
}
