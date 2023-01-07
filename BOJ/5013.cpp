#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans;
char k[1002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    ans = n;

    while (n--) {
        scanf("%s", k);

        bool isWin = true;
        int kSize = strlen(k);
        for (int i = 0; i < kSize - 1; i++) {
            if (k[i] == 'C' && k[i + 1] == 'D') {
                ans--;
                break;
            }
        }
    }

    printf("%d\n", ans);
}
