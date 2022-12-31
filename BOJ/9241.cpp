#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string a, b;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> a >> b;
    int left = 0;
    while (left < a.size() && left < b.size()) {
        if (a[left] != b[left])
            break;
        left++;
    }

    int right = 0;
    while (a.size() - right > left && b.size() - right > left) {
        if (a[a.size() - 1 - right] != b[b.size() - 1 - right])
            break;
        right++;
    }

    printf("%d\n", (int)b.size() - left - right);
}