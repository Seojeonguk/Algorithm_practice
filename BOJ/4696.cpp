#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

double processionsSize;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (scanf("%lf", &processionsSize) != EOF) {
        if (processionsSize == 0) {
            break;
        }
        double ans = 1.0f + processionsSize * (processionsSize + 1.0f) * (processionsSize * processionsSize + 1.0f);
        printf("%.2lf\n", ans);
    }
}