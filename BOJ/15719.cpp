#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int sum;
int n, k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		scanf("%d", &k);
		sum += k;
	}
	printf("%lld\n", sum - 1LL*(n - 1)*n / 2);
}