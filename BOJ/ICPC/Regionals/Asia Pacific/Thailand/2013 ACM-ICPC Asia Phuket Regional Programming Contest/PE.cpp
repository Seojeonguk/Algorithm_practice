#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
int arr[102];

int gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d", &n);

		for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
		ll ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				ans += gcd(arr[i], arr[j]);
		printf("%lld\n", ans);
	}
}