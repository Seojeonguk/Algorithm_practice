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
	scanf("%d", &n);

	while (n != 1) {
		printf("%d ", n);
		if (n % 2) n = n * 3 + 1;
		else n /= 2;
	} printf("1");
}