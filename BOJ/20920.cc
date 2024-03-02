#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k;
map<string, int> m;
string a;
vector<string> v[100001];

bool cmp(string x, string y) {
    if (x.size() != y.size()) 
        return x.size() > y.size();
    return x < y;
}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        cin >> a;

        if (a.size() < k)
            continue;

        m[a]++;
    }
    
    for (auto it : m) 
        v[it.second].push_back(it.first);

    for (int i = 100000; i >= 0; i--) {
        sort(v[i].begin(), v[i].end(), cmp);
        for (string s : v[i])
            cout << s << "\n";
    }
}