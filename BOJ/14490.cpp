#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
int Euclidean(int a, int b) {
	if (a%b == 0) return b;
	return Euclidean(b, a%b);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d:%d", &n, &m);
	int gretest_common_divisor = Euclidean(n, m);
	printf("%d:%d\n", n / gretest_common_divisor, m / gretest_common_divisor);
}