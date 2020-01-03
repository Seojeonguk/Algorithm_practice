#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, n, p,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &x, &n);

	ans = x;
	for (int i = 0; i < n; i++) {
		scanf("%d", &p);
		ans += x-p;
	}
	printf("%d\n", ans);
}