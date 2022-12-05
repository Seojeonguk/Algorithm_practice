#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int byteCnt;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &byteCnt);

    for (int idx = 0; idx < byteCnt / 4; idx++) {
        printf("long ");
    }
    printf("int\n");
}