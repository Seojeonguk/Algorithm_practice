#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {

        if (i % 3 && i % 5) {
            printf("%d ", i);
            continue;
        }
        string str;
        if (!(i % 3)) str += "Dead";
        if (!(i % 5)) str += "Man";
        cout << str << "\n";
    }
}
