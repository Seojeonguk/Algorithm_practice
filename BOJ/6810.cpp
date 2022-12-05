#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int sum13 = 91;
int multiple = 1;
int lastdigit;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int idx = 0; idx < 3; idx++) {
        scanf("%d", &lastdigit);
        sum13 += (lastdigit * multiple);
        multiple = (multiple + 2) % 4;
    }
    printf("The 1-3-sum is %d\n", sum13);
}