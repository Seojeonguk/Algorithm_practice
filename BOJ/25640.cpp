#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string jinhoMBTI, friendMBTI;
int t, ans;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> jinhoMBTI >> t;
    while (t--) {
        cin >> friendMBTI;
        if (!jinhoMBTI.compare(friendMBTI))
            ans++;
    }
    cout << ans;
}