#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &a, &b);
	if (b <= 3) {
		puts("0");
		return 0;
	}
	if (a <= 2) a = 4;

	b = b / 2;
	a = (a + 1) / 2 - 1;
	printf("%lld", b*(b + 1) - a * (a + 1));
}