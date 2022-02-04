#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
char arr[200002];
bool java;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %s", &n, arr);

    for (int i = 0; arr[i]; i++) {
        if (arr[i] == 'J' || arr[i] == 'A' || arr[i] == 'V') continue;
        java = true;
        printf("%c", arr[i]);
    }
    if (!java) puts("nojava");
}