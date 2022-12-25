#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char c;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%c", &c);
    if (c == 'N' || c == 'n') {
        puts("Naver D2");
    }
    else {
        puts("Naver Whale");
    }
}