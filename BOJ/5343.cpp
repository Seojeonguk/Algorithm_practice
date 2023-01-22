#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
char s[65];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf(" %s", s);
        int ans = 0;
        for (int i = 0; i < strlen(s); i += 8) {
            int oneCnt = 0;
            for (int j = 0; j < 7; j++) 
                if (s[i + j] == '1')
                    oneCnt++;

            int perrity = oneCnt % 2;
            if (s[i + 7] % 2 != oneCnt % 2)
                ans++;
        }
        printf("%d\n", ans);
    }
}
