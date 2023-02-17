#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, a, b, p[5050], ans;
ll MOD = 1e9 + 7;
ll dp[5050][5050];
int find(int x) {
	if (x == p[x]) return x;
	return p[x] = find(p[x]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return;
	p[b] = a;
	ans--;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	ans = n;

	for (int i = 1;i <= n; i++) {
		p[i] = i;
		dp[i][1] = 1;
		for (int j = 2; j <= i; j++)
			dp[i][j] = (dp[i - 1][j - 1] + j * dp[i - 1][j] % MOD) % MOD;
	}

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= i; j++)
			dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;

	while (m--) {
		scanf("%d %d", &a, &b);
		merge(a, b);
		printf("%lld\n", dp[ans][ans]);
	}
}
