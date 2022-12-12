#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc, width, height;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &tc);

    for (int testCase = 0; testCase < tc; testCase++) {
        scanf("%d %d", &width, &height);
        printf("%d\n", width * height / 2);
    }
}