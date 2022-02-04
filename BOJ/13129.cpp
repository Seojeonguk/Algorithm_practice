#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &b, &n);

	for (int i = n; i >= 1; i--) {
		printf("%d ", b + a * i + (a + b) * (n - i));
	}
}