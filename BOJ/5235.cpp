#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);

		int even = 0, odd = 0;
		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			if (x & 1) odd += x;
			else even += x;
		}
		if (odd > even) puts("ODD");
		else if (odd < even) puts("EVEN");
		else puts("TIE");
	}
}