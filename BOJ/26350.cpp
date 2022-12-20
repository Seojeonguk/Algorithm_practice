#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int countryCnt, coinCnt;
int coins[12];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &countryCnt);

    while (countryCnt--) {
        scanf("%d", &coinCnt);

        bool denominations = true;
        for (int i = 1; i <= coinCnt;i++) {
            scanf("%d", &coins[i]);
            if (coins[i] < coins[i - 1] * 2) {
                denominations = false;
            }
        }

        printf("Denominations: ");
        for (int i = 1; i <= coinCnt; i++)
            printf("%d ", coins[i]);
        printf("\n%s coin denominations!\n\n", denominations ? "Good" : "Bad");
    }
}