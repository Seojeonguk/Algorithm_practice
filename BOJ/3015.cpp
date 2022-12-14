#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, height;
stack<pair<int,int> > s;
ll ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &height);

        while (!s.empty() && s.top().first < height) {
            ans += s.top().second;
            s.pop();
        }
        
        int cnt = 1;
        if (!s.empty() && s.top().first == height) {
            ans += s.top().second;
            cnt += s.top().second;
            s.pop();
        }
        if (!s.empty()) ans++;
        s.push({ height,cnt });
    }

    printf("%lld\n", ans);
}