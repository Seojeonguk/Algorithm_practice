#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 3; i <= n; i += 3) {
		if (i + 6 > n) break;
		for (int j = 3; j <= n; j += 3) {
			if (n - i - j <= 0) break;
			if ((n - i - j) % 3 == 0)
				ans++;
		}
	}
	printf("%d\n", ans);
}