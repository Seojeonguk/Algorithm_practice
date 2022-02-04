#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, y, m, d;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d %d", &y, &m, &d);

		int cnt = 0;
		while (1) {
			if (y == 1000 && m == 1 && d == 1) break;
			d++;
			cnt++;
			int year_1 = y % 3;
			int month_on_max_day = 20;
			if (year_1 && !(m & 1))
				month_on_max_day = 19;
			if (d > month_on_max_day) {
				d = 1;
				m++;
				if (m > 10) {
					y++;
					m = 1;
				}
			}
		}
		printf("%d\n", cnt);
	}
}