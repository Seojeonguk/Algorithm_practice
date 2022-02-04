#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
priority_queue<ll> pq;
ll x, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        scanf("%lld", &x);
        x -= i;

        pq.push(x);
        if (x < pq.top()) {
            ans += pq.top() - x;
            pq.push(x);
            pq.pop();
        }
    }

    printf("%lld", ans);
}