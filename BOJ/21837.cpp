#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
map<string, set<string>> M;
set<string> countries;
map<string, int> next_countries, prev_countries;

string first, line, dst, src, dummy;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        getline(cin, line);
        stringstream ss(line);
        ss >> dst;
        countries.insert(dst);
        if (i == 0) first = dst;
        ss >> dummy;
        ss >> dummy;
        ss >> dummy;
        while (ss >> src) {
            M[src].insert(dst);
        }
    }
    next_countries[first] = 1;
    for (int i = 1; i < 350; i++) {
        prev_countries = next_countries;

        for (auto it : countries) {
            if (prev_countries[it] == i) {
                set<string> dsts = M[it];
                for (auto it2 : dsts)
                    if (!next_countries[it2])
                        next_countries[it2] = i + 1;
            }
        }
    }

    for (auto it : countries)
        cout << next_countries[it] << "\n";
}
