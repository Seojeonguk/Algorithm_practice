#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, ans[102];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	ans[1] = 1;
	for (int i = 3; i < 101; i+=2)
		ans[i] = ans[i - 2] + i;

	while (t--) {
		scanf("%d", &n);
		printf("%d\n", ans[n]);
	}
}