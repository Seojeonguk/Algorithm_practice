#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	while (n--) {
		scanf("%d", &x);
		int tmp = x % 10;
		x /= 10;
		int tmp2 = 1;
		for (int i = 0; i < tmp; i++)
			tmp2 *= x;

		ans += tmp2;
	}
	printf("%d\n", ans);
}