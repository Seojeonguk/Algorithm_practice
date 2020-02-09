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
	for (scanf("%d", &t); t--;) {
		scanf("%d", &n);
		int ans = 0;
		for (int i = 1; i <= n; i++)
			if (n%i == 0) ans++;
		printf("%d %d\n", n, ans);
	}
}