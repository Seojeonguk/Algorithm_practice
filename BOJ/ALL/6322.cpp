#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int a, b, c; double ans;
	for(int i=1; ; i++) {
		scanf("%d %d %d", &a, &b, &c);
		if (!a) break;
		printf("Triangle #%d\n", i);
		if (c == -1) {
			ans = sqrt(a*a + b * b);
			if (a + b > ans && a < ans && b < ans) printf("c = %.3lf\n", ans);
			else puts("Impossible.");
		}
		else if (a == -1) {
			ans = sqrt(c*c - b * b);
			if (ans + b > c && ans < c && b < c) printf("a = %.3lf\n", ans);
			else puts("Impossible.");
		}
		else if (b == -1) {
			ans = sqrt(c*c - a * a);
			if (a + ans > c && a < c && ans < c) printf("b = %.3lf\n", ans);
			else puts("Impossible.");
		}
		puts("");
	}
}