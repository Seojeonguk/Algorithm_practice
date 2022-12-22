#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int, int> today, tomorrow;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &today.first, &today.second);
    scanf("%d %d", &tomorrow.first, &tomorrow.second);

    if (tomorrow.first < 0 && tomorrow.second >= 10) {
        puts("A storm warning for tomorrow! Be careful and stay home if possible!");
    }
    else if (tomorrow.first < today.first) {
        puts("MCHS warns! Low temperature is expected tomorrow.");
    }
    else if (tomorrow.second > today.second) {
        puts("MCHS warns! Strong wind is expected tomorrow.");
    }
    else
        puts("No message");
}