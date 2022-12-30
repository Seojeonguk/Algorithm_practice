#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[1000002];
int b, c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", a);

    for (int i = 0; a[i]; i++) {
        if (a[i] == 'B') b++;
        else c++;
    }

    printf("%d\n", b / 2 + c / 2);
}
