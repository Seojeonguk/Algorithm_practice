#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	for (int i = 0; i < k; i++) {
		if (n % 10 != 0)n--;
		else n /= 10;
	}

	printf("%d\n", n);
}