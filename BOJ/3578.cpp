#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int h;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &h);

    if (h == 0) puts("1");
    else if (h == 1) puts("0");
    else {
        if (h % 2) printf("4");
        for (int i = 0; i < h / 2; i++)
            printf("8");
    }
}
