#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char arr[1000002];

int solve() {
    for (int i = 0; arr[i]; i++) {
        if (arr[i] != arr[0]) {
            return i;
        }
    }
    return strlen(arr);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", arr);

    printf("%d\n", solve());
}