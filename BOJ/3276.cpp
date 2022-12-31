#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    int s = sqrt(n);

    if (s * s >= n) printf("%d %d\n", s, s);
    else if ((s + 1) * s >= n)printf("%d %d\n", s + 1, s);
    else printf("%d %d\n", s + 1, s + 1);
}
