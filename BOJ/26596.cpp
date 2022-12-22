#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t;
map<string, int> m;
string material;
int amount;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        cin >> material >> amount;
        if (m.find(material) != m.end()) {
            amount += m[material];
        }
        m[material] = amount;
    }
    for (auto it : m) {
        for (auto it2 : m) {
            if (it == it2) {
                continue;
            }
            int t1 = (int)(1.618 * it.second);
            if (t1 == it2.second) {
                puts("Delicious!");
                return 0;
            }
        }
    }
    puts("Not Delicious...");
}