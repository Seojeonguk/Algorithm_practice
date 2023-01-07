#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, e, a[22];
set<int> s;
int ans;
bool isVisit[10002][11];

void solve(int sum, int cnt, int idx) {
    if (cnt == e+1) return;
    if (sum) s.insert(sum);
    for (int i = idx; i < n; i++) {
        int nextSum = sum + a[i];
        if (isVisit[nextSum][cnt + 1])
            continue;
        isVisit[nextSum][cnt + 1] = true;
        solve(nextSum, cnt + 1, i);
    }
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &e);
    
    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    solve(0, 0,0);

    int value = 0, cnt = 0;
    for (int q : s) {
        if (value + cnt == q) {
            cnt++;
        }
        else {
            ans = max(ans, cnt);
            value = q;
            cnt = 1;
        }
    }
    ans = max(ans, cnt);
    printf("%d\n", ans);
}
