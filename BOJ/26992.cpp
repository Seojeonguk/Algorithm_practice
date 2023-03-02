#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int solve(vector<int> v) {
    int ret = 0;
    int cnt = 0;

    for (int i = 1; i < 19; i++) {
        if (!v[i - 1]) continue;
        cnt++;
        v[i - 1] = 0;
        v[i] = !v[i];
        v[i + 1] = !v[i + 1];
    }

    if (v[18] == v[19]) ret = cnt + v[18];
    else ret = 99999;

    return ret;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    vector<int> v(20);
    for (int i = 0; i < 20; i++) { 
        scanf("%d", &v[i]);
    }
    int ans = solve(v);
    v[0] = !v[0];
    v[1] = !v[1];

    ans = min(ans, 1 + solve(v));

    printf("%d\n", ans);
}
