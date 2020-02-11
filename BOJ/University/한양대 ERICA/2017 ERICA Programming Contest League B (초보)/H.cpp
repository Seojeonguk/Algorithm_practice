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

	for (int i = n / 5; i >= 0; i--) {
		if (i * 5 + (n - i * 5) / 2 * 2 == n) {
			printf("%d\n", i + (n - i * 5) / 2);
			return 0;
		}
	}
	puts("-1");
}