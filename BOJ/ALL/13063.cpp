#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d", &n, &m, &k);
		if (n == 0) break;

		int total = n - m - k;
		int tmp_m = m + total;
		int tmp_k = k;
		bool chk = false;
		for (int i = 0; i <= total; i++) {
			tmp_m = m + total - i;
			tmp_k = k + i;
			if (tmp_m <= tmp_k) {
				if (chk) tmp_m++;
				break;
			}
			chk = true;
		}
		printf("%d\n", (chk ? tmp_m - m : -1));
	}
}