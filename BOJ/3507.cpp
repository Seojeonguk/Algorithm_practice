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
	if (n > 198) {
		puts("0");
		return 0;
	}
	for (int i = 0; i < 100; i++)
		if (n - i >= 0 && n - i < 100) ans++;

	printf("%d\n", ans);
}