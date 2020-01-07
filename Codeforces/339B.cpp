#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
#define ll long long int
ll n, m,x,ans,now;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%I64d %I64d", &n, &m);
	now = 1;

	for (int i = 0; i < m; i++) {
		scanf("%I64d", &x);
		if (now < x) ans += x-now;
		else if (now > x) ans += n - now + x;
		now = x;
	}
	printf("%I64d\n", ans);
}