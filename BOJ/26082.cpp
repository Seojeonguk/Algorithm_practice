#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int competitorPrice, competitorPerformance, warboyPrice;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &competitorPrice, &competitorPerformance, &warboyPrice);

    printf("%d\n", competitorPerformance / competitorPrice * 3 * warboyPrice);
}