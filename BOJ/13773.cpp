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
		if (!n) break;
		printf("%d ", n);
		if (n == 1916 || n == 1940 || n == 1944) puts("Games cancelled");
		else if (n == 2024 || n == 2028) puts("No city yet chosen");
		else if (n % 4 == 0 && n>=1896) puts("Summer Olympics");
		else puts("No summer games");
	}
}