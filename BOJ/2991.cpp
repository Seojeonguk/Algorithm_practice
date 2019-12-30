#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c, d, des;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &c, &d);
	for (int i = 0; i < 3; i++) {
		int ans = 0;
		scanf("%d", &des);
		int q = des % (a + b), w = des % (c + d);
		if (q && q <= a) ans++;
		if (w && w <= c) ans++;
		printf("%d\n", ans);
	}
}