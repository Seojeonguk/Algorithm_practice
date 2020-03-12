#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		int x; scanf("%d", &x);
		printf("Case %d:\n", i);
		for (int j = 1; j <= x / 2; j++) {
			if (j > 6 || x - j > 6) continue;
			printf("(%d,%d)\n", j, x - j);
		}
	}
}