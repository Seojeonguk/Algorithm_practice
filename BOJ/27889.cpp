#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[1002];
int i;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", a);

    if (a[0] == 'N') puts("North London Collegiate School");
    else if (a[0] == 'B') puts("Branksome Hall Asia");
    else if (a[0] == 'K') puts("Korea International School");
    else if (a[0] == 'S') puts("St. Johnsbury Academy");
}
