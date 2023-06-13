#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, minX, minY, maxX, maxY, x, y;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    minX = minY = 999999;
    maxX = maxY = -999999;

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d %d", &x, &y);

        minX = min(minX, x);
        maxX = max(maxX, x);

        minY = min(minY, y);
        maxY = max(maxY, y);
    }

    printf("%d\n", (maxX - minX) * (maxY - minY));
}