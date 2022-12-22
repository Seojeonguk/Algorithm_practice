#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

pair<int, int> notebook, sticker;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &notebook.first, &notebook.second);
    scanf("%d %d", &sticker.first, &sticker.second);

    if (sticker.first + 2 <= notebook.first && sticker.second + 2 <= notebook.second) {
        puts("1");
    }
    else {
        puts("0");
    }
}