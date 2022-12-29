#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string msg;
int idx;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> msg;
    while (idx < msg.size()) {
        cout << msg[idx];
        idx = idx + (msg[idx] - 'A' + 1);
    }
}