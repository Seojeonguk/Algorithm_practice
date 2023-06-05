#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans, paintings[102][102];
int cnt[3];

void cal() {
    if (!cnt[1] && !cnt[2]) return;
    ans += min(cnt[1], cnt[2]) + 1;
    cnt[1] = cnt[2] = 0;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &paintings[i][j]);
            if (paintings[i][j])  cnt[paintings[i][j]] += (paintings[i][j] != paintings[i][j - 1] ? 1 : 0);
            else cal();
        }
        cal();
    }

    printf("%d\n", ans);
}
