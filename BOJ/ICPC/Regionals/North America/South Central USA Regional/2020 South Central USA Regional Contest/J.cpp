#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[53];
int cnt[27];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s ", arr);
    bool chk = false;
    for (int i = 0; i < strlen(arr); i++) {
        if (++cnt[arr[i] - 'a'] > 1) {
            chk = true;
            break;
        }
    }
    puts(!chk ? "1" : "0");
}