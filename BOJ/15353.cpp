#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[10002], b[10002];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s %s", a, b);
    int aIdx = strlen(a) - 1;
    int bIdx = strlen(b) - 1;

    int carry = 0;
    stack<int> s;
    while (aIdx > -1 || bIdx > -1) {
        int sum = (aIdx == -1 ? 0 : a[aIdx--] - '0') + (bIdx == -1 ? 0 : b[bIdx--] - '0') + carry;
        s.push(sum % 10);
        carry = sum / 10;
    }

    if (carry) {
        s.push(carry);
    }

    while (!s.empty()) {
        printf("%d", s.top());
        s.pop();
    }
}