#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a[2], b[2];

int gcd(int x, int y) {
	if (y == 0) return x;
	return gcd(y, x%y);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a[0], &a[1], &b[0], &b[1]);
	int chk = a[1] * b[1] / gcd(a[1], b[1]);
	a[0] *= chk / a[1];
	b[0] *= chk / b[1];
	a[0] += b[0];

	int last = gcd(a[0], chk);

	printf("%d %d\n", a[0] / last, chk / last);

}