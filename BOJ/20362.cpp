#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
string ans_nick, a, b;
map<string, int> m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> n >> ans_nick;

	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		if (a == ans_nick) cout << m[b];
		else {
			if (m.find(b) != m.end()) m[b]++;
			else m.insert({ b,1 });
		}
	}
}