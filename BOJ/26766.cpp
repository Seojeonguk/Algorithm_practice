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

    while (n--) {
        puts(" @@@   @@@ ");
        puts("@   @ @   @");
        puts("@    @    @");
        puts("@         @");
        puts(" @       @ ");
        puts("  @     @  ");
        puts("   @   @   ");
        puts("    @ @    ");
        puts("     @     ");
    }
}