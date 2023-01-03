#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, twoCnt, eCnt;
string s;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> n >> s;

    for (int i = 0; i < n; i++)
        if (s[i] == '2') twoCnt++;
        else eCnt++;

    if (twoCnt > eCnt) puts("2");
    else if (twoCnt < eCnt) puts("e");
    else puts("yee");
}
