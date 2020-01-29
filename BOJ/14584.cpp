#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
string str, word[20];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> str;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) cin >> word[i];

	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < n; j++) {
			if (str.find(word[j]) != string::npos) {
				cout << str << "\n";
				return 0;
			}
		}

		for (int j = 0; j < str.length(); j++) str[j] = (str.at(j) - 'a' + 1) % 26 + 'a';
	}
}