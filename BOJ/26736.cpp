#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int a, b;
char arr[100002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", arr);

    for (int i = 0; arr[i]; i++) {
        if (arr[i] == 'A') a++;
        else b++;
    }

    printf("%d : %d\n", a, b);
}