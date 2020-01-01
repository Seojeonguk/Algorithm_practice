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
	scanf("%d %d", &a, &b);

	int si = 0, bun = 0;
	do {
		if (si == a && bun == b) {
			puts("O");
			return 0;
		}
		si += 1;
		bun += 12;
		si %= 360, bun %= 360;
	} while (si != 0 || bun != 0);
	puts("X");
}