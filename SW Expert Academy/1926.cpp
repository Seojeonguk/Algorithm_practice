#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;

int solve(int x) {
	int ret = 0;
	while (x) {
		if (x % 10 == 3 || x % 10 == 6 || x % 10 == 9) ret++;
		x /= 10;
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		int chk = solve(i);

		for (int j = 0; j < chk; j++) printf("-");
		if (!chk) printf("%d", i);

		printf(" ");
	}
}