#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		while (1) {
			int now = 9;
			int tmp = n;
			bool chk = true;
			while (tmp) {
				if (tmp % 10 > now) {
					chk = false;
					break;
				}
				else now = tmp % 10;
				tmp /= 10;
			}
			if (chk) {
				printf("Case #%d: %d\n", tc, n);
				break;
			}
			n--;
		}
	}
}