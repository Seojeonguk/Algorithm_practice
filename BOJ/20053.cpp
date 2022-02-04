#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;
int arr[1000002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 0; tc < t; tc++) {
		scanf("%d", &n);

		for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
		sort(arr, arr + n);

		printf("%d %d\n", arr[0], arr[n - 1]);
	}
}