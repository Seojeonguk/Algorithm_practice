#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int,int> zeroOrOne[3];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 3; i++) {
        scanf("%d", &zeroOrOne[i].first);
        zeroOrOne[i].second = i;
    }

    sort(zeroOrOne, zeroOrOne + 3);

    if (zeroOrOne[0].first == zeroOrOne[2].first) {
        puts("*");
    }
    else {
        printf("%c", zeroOrOne[1].first == 1 ? zeroOrOne[0].second + 'A' : zeroOrOne[2].second + 'A');
    }
}