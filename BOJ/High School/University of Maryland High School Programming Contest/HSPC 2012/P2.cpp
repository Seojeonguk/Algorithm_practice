#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
string a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		int length = a.length();

		cout << "Distances: ";

		for (int j = 0; j < length; j++) {
			if (b[j] - a[j] < 0) cout << b[j] - a[j] + 26 << ' ';
			else cout << b[j] - a[j] << ' ';
		}
		cout << endl;
	}
}