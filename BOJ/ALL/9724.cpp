#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, a, b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &a, &b);
		int sum = 0;

		long long int now = 1;

		while (1) {
			long long int now_3 = now * now * now;

			if (now_3 > b) break;
			if (a <= now_3) sum++;
			now++;
		}

		printf("Case #%d: %d\n", tc, sum);
	}
}