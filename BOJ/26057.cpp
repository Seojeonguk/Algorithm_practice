#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &a, &b);

    printf("%d\n", 2 * b - a);
}
