#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, arr[6], a[6] = { 0,0,0,1000,1000,1000 };
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < 6; j++) {
			scanf("%d", &arr[j]);
			if (j < 3) a[j] = max(a[j], arr[j]);
			else a[j] = min(a[j], arr[j]);
		}
	}
	if (a[0] < a[3] && a[1] < a[4] && a[2] < a[5])
		printf("%lld\n", 1LL * (a[3] - a[0])*(a[4] - a[1])*(a[5] - a[2]));
	else puts("0");
}