#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, k;

struct dd {
	int a, b, c, d,i;
}d[101];

bool comp(dd d1,dd d2) {
	return d1.d > d2.d;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &k);

		for (int i = 0; i < n; i++) {
			scanf("%d %d %d", &d[i].a, &d[i].b, &d[i].c);
			d[i].d = d[i].a * 35 + d[i].b * 45 + d[i].c * 20;
			d[i].i = i;
		}

		sort(d, d + n, comp);



		printf("#%d ", tc);

		int chk = 0;
		for (int i = 0; i < n; i++) {
			if (k - 1 == d[i].i) {
				chk = i / (n / 10);
				break;
			}
		}

		if (chk == 0) puts("A+");
		else if (chk == 1) puts("A0");
		else if (chk == 2) puts("A-");
		else if (chk == 3) puts("B+");
		else if (chk == 4) puts("B0");
		else if (chk == 5) puts("B-");
		else if (chk == 6) puts("C+");
		else if (chk == 7) puts("C0");
		else if (chk == 8) puts("C-");
		else if (chk == 9) puts("D0");
	}
}