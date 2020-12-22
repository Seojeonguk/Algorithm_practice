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
	int now = 1;
	for (int i = 1; i <= n; i++) {
		now *= i;
		now %= 10;
	}
	printf("%d\n", now);
}