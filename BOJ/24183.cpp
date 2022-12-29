#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &a, &b, &c);

    double a_weight = 1.0f * 0.229 * 0.324 * a;
    double b_weight = 1.0f * 0.297 * 0.42 * b;
    double c_weight = 1.0f * 0.21 * 0.297 * c;

    printf("%lf\n", 2 * a_weight + 2 * b_weight + c_weight);
}