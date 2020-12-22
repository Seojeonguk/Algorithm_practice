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
	while (1) {
		scanf("%d", &n);
		if (!n) break;

		int l = 1, r = 50;
		while (l <= r) {
			int m = (l + r) / 2;
			printf("%d ", m);
			if (m == n) break;

			if (m >= n) r = m - 1;
			else l = m + 1;
		}
		puts("");
	}
}