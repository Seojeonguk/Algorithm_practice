#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

void print(int);
string str;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> str;

    for (int i = 0; i < str.size(); i++) {
        print(str[i] - '0');
        puts("");
    }
}

void print(int x) {
    if (x == 0) {
        puts("0000");
        puts("0  0");
        puts("0  0");
        puts("0  0");
        puts("0000");
    }
    else if (x == 1) {
        puts("   1");
        puts("   1");
        puts("   1");
        puts("   1");
        puts("   1");
    }
    else if (x == 2) {
        puts("2222");
        puts("   2");
        puts("2222");
        puts("2");
        puts("2222");
    }
    else if (x == 3) {
        puts("3333");
        puts("   3");
        puts("3333");
        puts("   3");
        puts("3333");
    }
    else if (x == 4) {
        puts("4  4");
        puts("4  4");
        puts("4444");
        puts("   4");
        puts("   4");
    }
    else if (x == 5) {
        puts("5555");
        puts("5");
        puts("5555");
        puts("   5");
        puts("5555");
    }
    else if (x == 6) {
        puts("6666");
        puts("6");
        puts("6666");
        puts("6  6");
        puts("6666");
    }
    else if (x == 7) {
        puts("7777");
        puts("   7");
        puts("   7");
        puts("   7");
        puts("   7");
    }
    else if (x == 8) {
        puts("8888");
        puts("8  8");
        puts("8888");
        puts("8  8");
        puts("8888");
    }
    else if (x == 9) {
        puts("9999");
        puts("9  9");
        puts("9999");
        puts("   9");
        puts("   9");
    }
}