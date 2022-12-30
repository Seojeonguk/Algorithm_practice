#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[1000002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", a);

    int l = strlen(a);

    replace(a, a + l, 'a', '4');
    replace(a, a + l, 'e', '3');
    replace(a, a + l, 'i', '1');
    replace(a, a + l, 'o', '0');
    replace(a, a + l, 's', '5');

    puts(a);
}
