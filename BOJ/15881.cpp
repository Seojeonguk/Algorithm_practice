#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans;
string things;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> n >> things;

    for (int i = 0; i < things.size() - 3; i++) {
        string subThings = things.substr(i, 4);
        if (!subThings.compare("pPAp")) {
            ans++;
            i += 3;
        }
    }

    cout << ans;
}
