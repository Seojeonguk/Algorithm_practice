#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll w1, h1, w2, h2;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld %lld %lld %lld", &w1, &h1, &w2, &h2);

    printf("%lld\n", 2 * h1 + 2 * max(w1, w2) + 2 * h2 + 4);
}