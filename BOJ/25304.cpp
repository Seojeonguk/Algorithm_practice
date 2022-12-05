#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int total, thingCnt, money,cnt;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &total);
    scanf("%d", &thingCnt);
    for (int thing = 0; thing < thingCnt; thing++) {
        scanf("%d %d", &money, &cnt);
        total -= money * cnt;
    }
    if (total) {
        puts("No");
    }
    else {
        puts("Yes");
    }
}