#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int cnt[10];
int x;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 5; i++) {
        scanf("%d", &x);
        cnt[x]++;
    }

    for (int i = 0; i < 10; i++)
        if (cnt[i] % 2)
            printf("%d\n", i);
}