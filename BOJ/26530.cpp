#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string s;
int t,n;
double a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> t;
    while (t--) {
        cin >> n;
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            cin >> s >> a >> b;
            ans += a * b;
        }

        printf("$%.2lf\n", ans);
    }
}