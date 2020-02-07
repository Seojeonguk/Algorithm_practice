#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, a, b, ans,b_prev;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &t) && t!=-1) {
		ans = b_prev = 0;
		for (int i = 0; i < t; i++) {
			scanf("%d %d", &a, &b);
			ans += a * (b - b_prev);
			b_prev = b;
		}
		printf("%d miles\n", ans);
	}
}