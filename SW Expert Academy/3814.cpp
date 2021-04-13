#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, k;
int arr[100001],brr[100001], temp[100001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &k);

		for (int i = 0; i < n; i++)
			scanf("%d", &temp[i]);

		int l = 0, r = 1e9 + 1;
		while (l < r) {
			int mid = (l + r) / 2;
			int cnt = 0;
			for (int i = 0; i < n; i++)
				arr[i] = brr[i] = temp[i];

			for (int i = 1; i < n; i++) 
				arr[i] = min(arr[i], arr[i - 1] + mid);

			for (int i = n - 2; i >= 0; i--)
				brr[i] = min(brr[i], brr[i + 1] + mid);

			for (int i = 0; i < n; i++)
				cnt += temp[i] - min(arr[i], brr[i]);

			if (cnt <= k) r = mid;
			else l = mid + 1;
		}

		printf("#%d %d\n", tc, l);
	}
}