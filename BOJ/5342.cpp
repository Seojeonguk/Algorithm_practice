#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

map<string, double> m;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    m["Paper"] = 57.99;
    m["Printer"] = 120.50;
    m["Planners"] = 31.25;
    m["Binders"] = 22.50;
    m["Calendar"] = 10.95;
    m["Notebooks"] = 11.20;
    m["Ink"] = 66.95;

    string s;
    double ans = 0.0;
    while (1) {
        cin >> s;
        if (!s.compare("EOI"))
            break;
        ans += m[s];
    }
    printf("$%.2lf\n", ans);
}
