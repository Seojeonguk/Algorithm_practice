#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, y, c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &x, &y);
	int pos = x;

	for (int i = 1; ; i *= -2)
		for (; pos != x + i; pos += (i > 0 ? 1 : -1), c++)
			if (pos == y) {
				printf("%d\n", c);
				return 0;
			}
}