#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, a, b, c, d;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d %d %d", &a, &b, &c, &d);
		a += c;
		b += d;

		if (b >= 60) {
			b %= 60;
			a += 1;
		}

		while (a > 12) {
			a -= 12;
		}

		printf("#%d %d %d\n", tc, a, b);
	}
}