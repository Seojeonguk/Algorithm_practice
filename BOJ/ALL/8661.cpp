#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int s,x, k, a;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &x, &k, &a);
    int cnt = 0;
    while (s <= x) {
        if (cnt % 2) x -= a;
        else s += k;
        cnt++;
    }
    printf("%d\n", cnt%2);
}