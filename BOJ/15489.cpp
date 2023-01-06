#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int r, c, w, ans;
int a[32][32];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &r, &c, &w);
    for (int i = 1; i <= r + w; i++) {
        a[i][1] = a[i][i] = 1;
        for (int j = 2; j < i; j++)
            a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
    }

    for (int i = 0; i < w; i++)
        for (int j = 0; j <= i; j++)
            ans += a[r + i][c + j];

    printf("%d\n", ans);
}
