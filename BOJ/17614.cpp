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
		int tmp = i;
		while (tmp) {
			int chk = tmp % 10;
			if (chk == 3 || chk == 6 || chk == 9) ans++;
			tmp /= 10;
		}
	}
	printf("%d\n", ans);
}