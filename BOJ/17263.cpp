#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[500001];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    sort(arr, arr + n);

    printf("%d\n", arr[n - 1]);
}
