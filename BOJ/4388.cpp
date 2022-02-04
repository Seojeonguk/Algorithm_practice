#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &a, &b);
		if (!a && !b) break;
		int ans = 0,carry=0;
		while (1) {
			if (!a && !b) break;
			carry += a % 10 + b % 10;
			if (carry >= 10) ans++;
			a /= 10, b /= 10,carry/=10;
		}

		printf("%d\n", ans);
	}
}