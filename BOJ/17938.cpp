#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, p, t;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &n, &p, &t);
    p--;

    int start = 0, end = 0;
    int cnt = 1, plus = 1;
    for (int i = 0; i < t - 1; i++) {
        start = (end + 1) % (2 * n);
        end = (start + cnt) % (2 * n);

        cnt += plus;
        if (cnt == 2 * n-1 || cnt == 0)
            plus = -plus;
    }

    bool find = false;
    for (int idx = start; ; idx = (idx + 1) % (2 * n)) {
        if (idx == 2 * p || idx == 2 * p + 1)
            find = true;
        if (idx == end) break;
    }

    if (find) puts("Dehet YeonJwaJe ^~^");
    else puts("Hing...NoJam");
}