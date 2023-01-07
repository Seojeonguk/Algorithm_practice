#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, ballonCnt;
double weight, r;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    for (int tc = 1; tc <= t; tc++) {
        double helium = 0.0;
        scanf("%d %lf", &ballonCnt, &weight);

        for (int j = 1; j <= ballonCnt; j++) {
            scanf("%lf", &r);
            helium += 4.0 / 3.0 * 3.14159265359 * pow(r, 3) / 1000;
        }

        printf("Data Set %d:\n", tc);
        if (helium >= weight) puts("Yes\n");
        else puts("No\n");
    }
}
