#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;


int n, k;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &k);

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        scanf("%d", &v[i]);

    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());

    vector<int> v2(n - 1);
    for (int i = 0; i < v.size() - 1; i++)
        v2[i] = v[i + 1] - v[i];

    sort(v2.begin(), v2.end());

    ll ans = 0;

    if (v2.size() > k - 1) {
        for (int i = 0; i < v2.size() - k + 1; i++)
            ans += v2[i];
    }

    printf("%lld\n", ans);
}
