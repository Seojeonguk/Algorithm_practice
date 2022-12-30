#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, number;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        bool mack = false, zack = false;
        for (int i = 0; i < 10; i++) {
            scanf("%d", &number);
            if (number == 17) zack = true;
            else if (number == 18) mack = true;
            printf("%d ", number);
        }
        puts("");
        if (mack && zack) puts("both");
        else if (mack) puts("mack");
        else if (zack) puts("zack");
        else puts("none");
        puts("");
    }
}
