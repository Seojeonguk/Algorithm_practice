#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long n, k, l, r;
long long arr[10001]; 

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &n, &k);
	for (int i = 0; i < n; i++) scanf("%lld", &arr[i]);
	sort(arr, arr + n);
	l = 0, r = arr[n - 1];
	while (l <= r) {
		long long cnt = 0;
		long long mid = (l + r) / 2;
		if (mid == 0)
			cnt = k; 
		else {
			for (int i = 0; i < n; i++) {
				cnt += (arr[i] / mid);
			}
		}
		if (cnt < k) r = mid - 1;
		else l = mid + 1;
	}
	printf("%lld\n", l - 1);
}