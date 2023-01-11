#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
set<ll> s;
vector<ll> v;
vector<ll> ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    v.resize(n);
    ans.resize(3,-99999999999);

    for (int i = 0; i < n; i++)
        scanf("%lld", &v[i]);

    sort(v.begin(), v.end());

    for (int i = 0; i < n - 2; i++) {
        int l = i + 1, r = n - 1;
        while (l < r) {
            ll sum = v[i] + v[l] + v[r];
            if (abs(sum) < abs(ans[0] + ans[1] + ans[2])) {
                ans[0] = v[i];
                ans[1] = v[l];
                ans[2] = v[r];
            }
            if (sum >= 0) r--;
            else l++;
        }
    }

    sort(ans.begin(), ans.end());

    for (int i = 0; i < 3; i++)
        printf("%lld ", ans[i]);
}
