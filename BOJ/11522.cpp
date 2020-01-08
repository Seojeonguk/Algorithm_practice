#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int p, k, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &p);

	for (int i = 0; i < p; i++) {
		scanf("%d %d", &k, &n);
		printf("%d %d %d %d\n", k, n*(n + 1) / 2, n*n, n*(n + 1));
	}
}