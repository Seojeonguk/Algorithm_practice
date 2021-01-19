#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			ans += i * (i & 1 ? 1 : -1);
		}

		printf("#%d %d\n", tc, ans);
	}
}