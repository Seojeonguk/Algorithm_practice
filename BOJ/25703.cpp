#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
string a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    puts("int a;");
    a = "ptr";
    b = "a";

    string p = "*";
    for (int i = 1; i <= n; i++) {
        cout << "int " << p << a << " = &" << b << ";\n";
        b = a;
        a = "ptr" + to_string(i+1);    
        p.push_back('*');
    }
}