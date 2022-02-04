#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
map<int, int> m;

int solve(int x) {
	int ret = 0;
	while (x) {
		ret += (x % 10)*(x % 10);
		x /= 10;
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	while (1) {
		if (n == 1) break;
		m[n] = 1;
		n = solve(n);
		if (m.find(n) != m.end()) {
			puts("UNHAPPY");
			return 0;
		}
	}
	puts("HAPPY");
}