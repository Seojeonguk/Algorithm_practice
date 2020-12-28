#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char air[7], c;
int n, x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf(" %s %d", air, &n);
		if (air[0] == '#') break;
		while (1) {
			scanf("%c %d", &c, &x);
			if (c == 'X') break;
			if (c == 'B' && n + x <= 68) n += x;
			else if (c == 'C' && n - x >= 0) n -= x;
		}

		printf("%s %d\n", air, n);
	}
}