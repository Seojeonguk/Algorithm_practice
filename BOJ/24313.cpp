#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a1, a2, c, n0;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &a1, &a2, &c, &n0);

    int firstFn = a1 * n0 + a2;
    int firstGn = c * n0;

    puts(firstFn <= firstGn && a1 <= c ? "1" : "0");
}