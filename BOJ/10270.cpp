#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

const long long int MOD = 1000000007;
int t, n;
long long int ans[100005];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	ans[1] = 1;
	for (int i = 2; i <= 100000; i++)
		ans[i] = (ans[i - 1] * i) % MOD;

	while (t--) {
		scanf("%d", &n);

		printf("%lld\n", ans[n]-1);
	}
}