#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
int arr[101];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 1; i < 101; i++)
        arr[i] += arr[i - 1] + i;

    while (scanf("%d", &n) != EOF && n != 0) {
        printf("%d\n", arr[n]);
    }
}