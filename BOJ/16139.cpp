#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char a;
int q, l, r;
string s;
int accSum[200001][26];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> s;

    int size = s.size();
    for (int i = 0; i < size; i++)
        accSum[i][s[i] - 'a']++;

    for (int i = 0; i < 26; i++)
        for (int j = 1; j < size; j++)
            accSum[j][i] += accSum[j - 1][i];

    cin >> q;

    for (int i = 0; i < q; i++) {
        cin >> a >> l >> r;

        cout << accSum[r][a - 'a'] - (l == 0 ? 0 : accSum[l - 1][a - 'a']) << "\n";
    }
}