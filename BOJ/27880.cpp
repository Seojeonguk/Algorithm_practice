#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char adjacent[8];
int h, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for(int i=0;i<4;i++) {
        scanf("%s %d", adjacent, &h);
        ans += h * (adjacent[0] == 'E' ? 21 : 17);
    }

    printf("%d\n", ans);
}