#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    int round;
    scanf("%d", &round);
    printf("%d %d\n", (round + 1) * 2, (round + 1) * 3);
}