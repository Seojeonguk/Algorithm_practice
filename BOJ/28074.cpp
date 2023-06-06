#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a[102];
bool cnt[26];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%s", a);

    for (int i = 0; a[i]; i++)
        cnt[a[i] - 'A'] = true;

    puts((cnt['M' - 'A'] && cnt['O' - 'A'] && cnt['B' - 'A'] && cnt['I' - 'A'] && cnt['S' - 'A']) ? "YES" : "NO");
}