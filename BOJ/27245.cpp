#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int w, l, h;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d", &w, &l, &h);

    bool isGood = true;
    if (min(w, l) < 2 * h) isGood = false;
    if (min(w, l) * 2 < max(w, l)) isGood = false;

    puts(isGood ? "good" : "bad");
}
