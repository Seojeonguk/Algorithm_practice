#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[26];
bool b[26];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", a);

    for (int i = 0; a[i]; i++)
        b[a[i] - 'A'] = true;

    for (int i = 0; i < 26; i++)
        if (!b[i])
            printf("%c\n", 'A' + i);
}
