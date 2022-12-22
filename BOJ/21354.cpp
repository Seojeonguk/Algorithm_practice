#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int apple, pear;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &apple, &pear);

    apple *= 7;
    pear *= 13;
    if (apple > pear) {
        puts("Axel");
    }
    else if (apple < pear) {
        puts("Petra");
    }
    else {
        puts("lika");
    }
}