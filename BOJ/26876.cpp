#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int sth, stm, endh, endm;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d:%d", &sth, &stm);
    scanf("%d:%d", &endh, &endm);

    endm += endh * 60;
    stm += sth * 60;

    int d = endm-stm;
    if (d < 0) 
        d += 1440;

    printf("%d\n", d % 60 + d / 60);
}
