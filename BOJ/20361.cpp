#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x, k,a,b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &x, &k);

	for (int i = 0; i < k; i++) {
		scanf("%d %d", &a, &b);
		if (a == x) x = b;
		else if (b == x) x = a;
	}

	printf("%d\n", x);
}