#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a[3];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 3; i++)
        scanf("%d", &a[i]);

    sort(a, a + 3);
    if (a[0] + a[1] == a[2])
        puts("1");
    else if (a[0] * a[1] == a[2])
        puts("2");
    else puts("3");
}
