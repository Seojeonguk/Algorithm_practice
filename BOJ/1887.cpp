#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n, constraint, constraintCnt, ans;
int constraints[53];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &t, &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &constraintCnt);

        int x = 0;
        for (int j = 0; j < constraintCnt; j++) {
            scanf("%d", &constraint);
            x |= (1 << (constraint - 1));
        }
        constraints[i] = x;
    }

    for (int i = 0; i < (1 << (t)); i++) {
        bool isPossible = true;
        for (int j = 0; j < n; j++) {
            if ((i & constraints[j]) == constraints[j]) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) ans++;
    }

    printf("%d\n", ans);
} 
