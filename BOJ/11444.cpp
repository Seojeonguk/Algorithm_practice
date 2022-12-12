#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll n;
#define MOD 1000000007

vector<vector<ll> > multiply(vector<vector<ll> >& a, vector<vector<ll> >& b) {
    vector<vector<ll> > ret(2, vector<ll>(2));
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                ret[i][j] = (ret[i][j] + a[i][k] * b[k][j]) % MOD;
            }
        }
    }
    return ret;
}

vector<vector<ll> > solve(vector<vector<ll> > a, ll cnt) {
    vector<vector<ll> > init(2, vector<ll>(2));
    if (cnt <= 1) {
        return a;
        init[0][0] = init[0][1] = init[1][0] = 1;
        return init;
    }

    vector<vector<ll> > temp = solve(a,cnt / 2);
    vector<vector<ll> > ret = multiply(temp, temp);
    if (cnt % 2) {
        ret = multiply(ret, a);
    }

    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &n);
    n -= 1;

    vector<vector<ll> > init(2, vector<ll>(2));
    init[0][0] = init[0][1] = init[1][0] = 1;
    vector<vector<ll> > v = solve(init,n);

    printf("%lld\n", v[0][0]);
}