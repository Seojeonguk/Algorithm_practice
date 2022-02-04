#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

const int MAXN = 1e6 + 10;
const ll MOD = 1000000007;

int n;
int eul[MAXN];
ll temp[MAXN];
ll ans[MAXN];
void eular() {
    memset(eul, 0, sizeof eul);
    memset(temp, 0, sizeof temp);

    eul[1] = 1;
    for (int i = 2; i < MAXN; i++) {
        if (!eul[i]) {
            for (int j = i; j < MAXN; j += i) {
                if (!eul[j])
                    eul[j] = j;
                eul[j] = eul[j] / i * (i - 1);
            }
        }
    }
    ans[0] = ans[1] = 0;
    for (ll i = 2; i < MAXN; i++) {
        for (ll j = i; j < MAXN; j += i) {
            ll t = j * eul[i] / 2;
            temp[j] += i * t;
        }
        ans[i] = (ans[i - 1] + temp[i]) % MOD;
    }
}



int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    eular();

    scanf("%d", &n);

    printf("%lld\n", ans[n]);
}