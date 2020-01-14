#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, y, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &x, &y, &n);

	for (int i = 1; i <= n; i++) {
		if (i%x == 0) printf("Fizz");
		if (i%y == 0) printf("Buzz");
		if (i%x && i%y) printf("%d", i);
		puts("");
	}
}