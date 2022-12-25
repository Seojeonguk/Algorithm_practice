#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int chickenCnt, colaCnt, bearCnt;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &chickenCnt, &colaCnt, &bearCnt);

    int possibleforDrink = colaCnt / 2 + bearCnt;
    
    printf("%d\n", min(chickenCnt, possibleforDrink));
}