#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int operCnt, digitkeyCnt, targetValue, targetValueCnt;
int digitkeys[11];
int dp[8][5000002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &operCnt);

    scanf("%d", &digitkeyCnt);
    for (int i = 0; i < digitkeyCnt; i++) {
        scanf("%d", &digitkeys[i]);
        dp[0][digitkeys[i]] = 1;
    }

    for (int i = 0; i < operCnt; i++) {
        for (int j = 0; j < 5000002; j++) {
            if (dp[i][j]) {
                for (int k = 0; k < digitkeyCnt; k++) {
                    dp[i + 1][j + digitkeys[k]] = dp[i + 1][j * digitkeys[k]] = 1;
                }
            }
        }
    }

    scanf("%d", &targetValueCnt);
    for (int i = 0; i < targetValueCnt; i++) {
        scanf("%d", &targetValue);
        puts(dp[operCnt][targetValue] ? "Y" : "N");
    }
}