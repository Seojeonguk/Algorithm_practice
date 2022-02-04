#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	if (n <= 10) {
		puts("1");
		return 0;
	}
	int k = 1,ans=1;
	while (1) {
		if (n / k == 0) break;
		k = k * 10 + 1;
		ans++;
	}

	printf("%d\n", ans-1);
}