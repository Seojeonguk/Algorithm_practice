#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

const int MAXN = 1e5 + 3;
ll n;
ll eul[MAXN];
void eular() {

    eul[1] = 1;
    for (int i = 2; i < MAXN; i++) {
        if (!eul[i]) {
            for (int j = i; j < MAXN; j += i) {
                if (!eul[j])
                    eul[j] = j;
                eul[j] = 1LL * eul[j] / i * (i - 1LL);
            }
        }
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    eular();
    scanf("%lld", &n);

    int x = -1;
    for (int i = 0; i < MAXN; i++) {
        if (eul[i] * i == n) {
            x = i;
            break;
        }
    }
    printf("%d\n", x);
}