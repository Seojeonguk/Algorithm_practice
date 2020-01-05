#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
#define MOD 1000000007
long long int h, x, ans, high,cnt;
vector<int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &h, &x);
	high = x;
	for (int i = 0; i < h; i++) {
		scanf("%lld", &cnt);
		ans = (ans + cnt*high) % MOD;
		high = (high*x) % MOD;
	}
	printf("%lld\n", ans);
}