#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string str;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    getline(cin, str);

    int a = str[0] - '0';
    int b = str[4] - '0';
    int c = str[8] - '0';
    puts(a + b == c ? "YES" : "NO");
}