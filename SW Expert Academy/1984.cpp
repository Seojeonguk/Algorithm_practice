#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n,x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {

		int ans = 0;
		int mi = 10001;
		int ma = -1;

		for (int i = 0; i < 10; i++) {
			scanf("%d", &x);
			mi = min(mi, x);
			ma = max(ma, x);
			ans += x;
		}
		printf("#%d %d\n", tc, (ans-mi-ma+4)/8);
	}
}