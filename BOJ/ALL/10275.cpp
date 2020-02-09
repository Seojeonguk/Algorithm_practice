#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
long long int n,a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t);t--; ) {
		scanf("%lld %lld %lld", &n, &a, &b);
		n = (1LL << n);
		int ans = 0;
		
		while (a || b) {
			if (a >=n) a -= n;
			else if (b >= n)b -= n;
			if (ans) {
				if (a >= n) a -= n;
				else if (b >= n)b -= n;
			}
			n /= 2;
			ans++;
		}
		printf("%d\n", ans-1);
	}
}