#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t,k;
int ans[32];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ans[1] = 1;
	for (int i = 2; i <= 30; i++) {
		ans[i] = ans[i - 1] + (1 << (i - 1));
	}
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &k);
		printf("%d\n", ans[k]);
	}
}