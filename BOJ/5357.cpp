#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
char str[102];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);
    while (t--) {
        scanf(" %s", str);
        
        char recentLetter = 0;
        for (int idx = 0; idx < strlen(str); idx++) {
            if (recentLetter != str[idx]) {
                printf("%c", str[idx]);
                recentLetter = str[idx];
            }
        }
        puts("");
    }
}