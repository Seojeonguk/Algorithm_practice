#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		int tmp = i, sum = 0;
		while (tmp) {
			sum += tmp % 10;
			tmp /= 10;
		}
		if (i%sum == 0) ans++;
	}
	printf("%d\n", ans);
}