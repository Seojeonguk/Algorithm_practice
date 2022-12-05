#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int personCnt, shareAmount;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (scanf("%d %d", &personCnt, &shareAmount) != EOF) {
        printf("%d\n", shareAmount / (personCnt + 1));
    }
}