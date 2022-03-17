#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
using ll = long long;

ll n;
ll l, r = 3037000499;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld", &n);
	while (l <= r) {
		ll mid = (l + r) / 2;
		if (mid*mid < n) l = mid + 1;
		else r = mid - 1;
	}
	printf("%lld\n", l);
}