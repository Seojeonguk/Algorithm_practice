#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
string a;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		getline(cin, a);
		int chk, idx, length = a.length();
		for (chk = 0, idx = 0; idx < length; idx++) {
			if (a[idx] == ' ') {
				if (chk == 1)
					break;
				else chk++;
			}
		}

		for (int i = idx + 1; i < length; i++)
			cout << a[i];
		printf(" ");
		for (int i = 0; i < idx; i++)
			cout << a[i];
		printf("\n");
	}
}