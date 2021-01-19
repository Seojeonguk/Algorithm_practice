#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, arr[52];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

		sort(arr, arr + n);

		printf("#%d ",tc);

		for (int i = 0; i < n; i++) printf("%d ", arr[i]);

		puts("");
	}
}