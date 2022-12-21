#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string str;
priority_queue<string, vector<string>, greater<string> > pq;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> str;
    for (int i = 1; i < str.size() - 1; i++) {
        for (int j = 1; j < str.size() - i; j++) {
            string first = str.substr(0, i);
            string second = str.substr(i, j);
            string third = str.substr(i + j);

            reverse(first.begin(), first.end());
            reverse(second.begin(), second.end());
            reverse(third.begin(), third.end());
            pq.push(first + second + third);
        }
    }
    cout << pq.top() << endl;
}