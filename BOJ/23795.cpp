#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int money, total;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    while (1) {
        scanf("%d", &money);

        if (money == -1) {
            break;
        }
        total += money;
    }
    printf("%d\n", total);
}