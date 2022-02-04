#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int b, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &b, &n);
		if (!n) break;
		int ans = 100000000, a = 0;
		for (int i = 1;; i++) {
			int an = pow(i, n);
			if (ans > abs(b-an)) {
				ans = abs(b - an);
				a = i;
			}
			else break;
		}
		printf("%d\n", a);
	}
}