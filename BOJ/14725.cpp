#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k;
string str;

struct Trie {
    bool last = false;
    map<string, Trie*> m;

    void insert(deque<string>& dq) {
        if (dq.empty()) {
            last = true;
            return;
        }
        string nextStr = dq[0];

        if (m.find(dq[0]) == m.end()) {
            m.insert({ nextStr,new Trie });
        }
        deque<string> nextDq(dq);
        nextDq.pop_front();
        m[nextStr]->insert(nextDq);
    }

    void find(int depth) {

        for (auto it : m) {
            for (int i = 0; i < depth * 2; i++)
                printf("-");
            cout << it.first << endl;
            it.second->find(depth + 1);
        }
    }
};

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);

    Trie *t = new Trie;

    for (int i = 0; i < n; i++) {
        cin >> k;
        deque<string> dq(k);
        for (int j = 0; j < k; j++) 
            cin >> dq[j];
        t->insert(dq);
    }
    t->find(0);
}