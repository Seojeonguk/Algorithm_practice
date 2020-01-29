#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int c, f, ch, p;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d %d", &c, &f, &ch, &p);
		if (!c && !f && !ch && !p) break;
		c *= 10, f *= 10, ch *= 10, p *= 10;
		int low = (f ? f - 5 : 0) * 9 + (ch ? ch - 5 : 0) * 4 + (p ? p - 5 : 0) * 4;
		int high = (f + 5) * 9 + (ch + p + 10) * 4;
		if (low <= c && c <= high) puts("yes");
		else puts("no");
	}
}