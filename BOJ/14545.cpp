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

	while (t--) {
		scanf("%d", &n);
		long long ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += i * i;
		}
		printf("%lld\n", ans);
	}
}