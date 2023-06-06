#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int, int> hb[2];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 2; i++)
        scanf("%d %d", &hb[i].first, &hb[i].second);

    int fp = hb[0].first * 3 + hb[0].second;
    int sp = hb[1].first * 3 + hb[1].second;
    if (fp == sp) puts("NO SCORE");
    else printf("%d %d\n", fp < sp ? 2 : 1, abs(fp - sp));
}