#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long a, b, k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld %lld", &a, &b, &k);

	long long ans = 0;
	if (a / k == 0 || b / k == 0) ans = 0;
	else if (a / k == 1) ans = b / k;
	else if (b / k == 1) ans = a / k;
	else ans = a / k * 2LL + b / k * 2LL - 4;

	printf("%lld\n", ans);
}