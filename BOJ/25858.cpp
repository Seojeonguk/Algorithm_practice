#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, total, totalSolved;
int solved[32];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n,&total);

    for (int i = 0; i < n; i++) {
        scanf("%d", &solved[i]);
        totalSolved += solved[i];
    }

    for (int i = 0; i < n; i++) {
        printf("%d\n", total / totalSolved * solved[i]);
    }
}
