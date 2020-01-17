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
	while (1) {
		scanf("%d", &n);
		if (n == -1) break;
		int ans = 0, s, p, _p=0;
		for (int i = 0; i < n; i++) {
			scanf("%d %d", &s, &p);
			ans += (p - _p)*s;
			_p = p;
		}
		printf("%d miles\n", ans);
	}
}