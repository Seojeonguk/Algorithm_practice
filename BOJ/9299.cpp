#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,t,x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int k = 1; k <= t; k++) {
		scanf("%d", &n);
		printf("Case %d: %d ", k, n - 1);
		for (int i = 0; i <= n; i++) {
			scanf("%d", &x);
			if (i != n) printf("%d ", x*(n - i));
		}
		puts("");
	}
}