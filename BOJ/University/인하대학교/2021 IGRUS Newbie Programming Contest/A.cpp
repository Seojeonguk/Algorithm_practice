#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int num[3], ans = 1;
bool chk;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 3; i++) {
        scanf("%d", &num[i]);
        if (num[i] & 1) {
            ans *= num[i];
            chk = true;
        }
    }

    if (!chk) ans = num[0] * num[1] * num[2];
    printf("%d\n", ans);
}