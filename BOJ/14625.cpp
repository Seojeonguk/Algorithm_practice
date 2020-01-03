#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int st_h, st_m, de_h, de_m, n, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &st_h, &st_m, &de_h, &de_m, &n);

	while (st_h != de_h || st_m != de_m) {
		ans += (st_h / 10 == n ? 1 : 0) || (st_h % 10 == n ? 1 : 0) || (st_m / 10 == n ? 1 : 0) || (st_m % 10 == n ? 1 : 0);
		st_m += 1;
		if (st_m == 60) st_h++, st_m = 0;
	}
	ans += (st_h / 10 == n ? 1 : 0) || (st_h % 10 == n ? 1 : 0) || (st_m / 10 == n ? 1 : 0) || (st_m % 10 == n ? 1 : 0);
	printf("%d\n", ans);
}