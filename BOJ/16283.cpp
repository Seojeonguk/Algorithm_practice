#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, n, w,ans1,ans2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &n, &w);

	for (int i = 1; i < n; i++) {
		if (i*a + (n - i)*b == w) {
			if (ans1 || ans2) {
				puts("-1");
				return 0;
			}
			ans1 = i, ans2 = n - i;
		}
	}
	if (ans1 || ans2) printf("%d %d\n", ans1, ans2);
	else puts("-1");
}