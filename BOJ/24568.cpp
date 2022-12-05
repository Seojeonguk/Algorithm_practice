#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int regularboxCnt, smallboxCnt;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &regularboxCnt, &smallboxCnt);
    int studentCnt = 28;
    printf("%d\n", max(0, regularboxCnt * 8 + smallboxCnt * 3 - 28));
}