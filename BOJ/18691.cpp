#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, g, c, e;
int dis[4] = { 0,1,3,5 };

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d %d", &g, &c, &e);

        printf("%d\n", c < e ? (e - c) * dis[g] : 0);
    }
}
