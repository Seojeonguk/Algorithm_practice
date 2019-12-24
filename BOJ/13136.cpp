#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int r, c, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &r, &c, &n);
	int rr = r / n + (r%n ? 1 : 0);
	int cc = c / n + (c%n ? 1 : 0);
	printf("%lld\n", (long long int)rr*cc);
}