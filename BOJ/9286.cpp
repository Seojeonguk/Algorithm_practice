#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		scanf("%d", &m);
		printf("Case %d:\n", i);
		for (int j = 0; j < m; j++) {
			int x; scanf("%d", &x);
			if (x < 6) printf("%d\n", x + 1);
		}
	}
}