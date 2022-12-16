#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, cnt;

int recursion(const char* s, int l, int r) {
    cnt++;
    if (l >= r) return 1;
    else if (s[l] != s[r]) return 0;
    else return recursion(s, l + 1, r - 1);
}

int isPalindrome(const char* s) {
    return recursion(s, 0, strlen(s) - 1);
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    char s[1002] = { 0, };

    scanf("%d", &t);
    for (int i = 0; i < t; i++) {
        cnt = 0;
        scanf(" %s", s);

        int palindrome = isPalindrome(s);

        printf("%d %d\n", palindrome, cnt);
    }
}