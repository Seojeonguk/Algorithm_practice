#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int d, h, m;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &d, &h, &m);

	if (d == 11) {
		if (h < 11) { puts("-1"); return 0; }
		if (h == 11) {
			if (m < 11) puts("-1");
			else printf("%d\n", m - 11);
			return 0;
		}
		if (m < 11) h--, m += 60;
		printf("%d\n", (h - 11) * 60 + m - 11);
	}
	else {
		if (h < 11)d--, h += 24;
		if (m < 11) h--, m += 60;
		printf("%d\n", (d - 11) * 1440 + (h - 11) * 60 + m - 11);
	}
}