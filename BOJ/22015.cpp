#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int arr[3];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 3; i++)
        scanf("%d", &arr[i]);

    sort(arr, arr + 3);

    printf("%d\n", arr[2] - arr[1] + arr[2] - arr[0]);
}