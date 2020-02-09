#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b,c;

int fibo(int n) {
	double sqrt5 = sqrt(5);
	double ans = 1 / sqrt5 * (pow(((1.0 + sqrt5) / 2.0), n) - pow(((1.0 - sqrt5) / 2.0), n));
	return (int)ans;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d %d %d", &a, &b, &c)) {
		if (a + b + c == 0)
			break;

		printf("%d\n", fibo(c)*a + fibo(c+1) * b);
	}
}