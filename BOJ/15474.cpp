#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, a, b, c, d;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &n, &a, &b, &c, &d);

	printf("%d\n", min((n / a + (n%a ? 1 : 0))*b, (n / c + (n%c ? 1 : 0))*d));
}