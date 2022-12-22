#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &b);

    int p = 5 * b - 400;

    printf("%d\n%d", p, p == 100 ? 0 : (p > 100 ? -1 : 1));
}