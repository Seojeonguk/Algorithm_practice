#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int info;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    bool isCorresponding = false;
    for (int i = 0; i < 8; i++) {
        scanf("%d", &info);
        if (info == 9) {
            isCorresponding = true;
        }
    }
    if (isCorresponding) {
        puts("F");
    }
    else {
        puts("S");
    }
}