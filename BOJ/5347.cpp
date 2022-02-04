#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
unsigned long long int ans;

long long int GCD(int x, int y) {
	if (y == 0)	return x;
	else GCD(y, x%y);
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int test;
	cin >> test;
	while (test--) {
		unsigned long long int a, b;
		cin >> a >> b;
		ans = (a*b) / GCD(a, b);
		cout << ans << "\n";
	}
}