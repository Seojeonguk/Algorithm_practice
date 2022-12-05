#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int arrCnt, value;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int testCaseNum = 1;;testCaseNum++) {
        scanf("%d", &arrCnt);
        if (!arrCnt) {
            break;
        }
        for (int idx = 0; idx < arrCnt; idx++) {
            scanf("%d", &value);
        }
        printf("Case %d: Sorting... done!\n", testCaseNum);
    }
}