#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, fac[10];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	fac[1] = 1;
	for (int i = 2; i < 10; i++) fac[i] = fac[i - 1] * i;

	while (1) {
		scanf("%d", &x);
		if (!x) break;
		int ans = 0,i=1;
		while (x) {
			ans += (x % 10)*fac[i++];
			x /= 10;
		}
		printf("%d\n", ans);
	}
}