#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,arr[1002];
int xy[1002 * 1002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	sort(arr, arr + n);

	int cnt = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			xy[cnt++] = arr[i] + arr[j];

	sort(xy, xy + cnt);

	for (int i = n - 1; i >= 0; i--) {
		for (int j = n - 1; j >= 0; j--) {
			if (binary_search(xy, xy + cnt, arr[i] - arr[j])) {
				printf("%d\n", arr[i]);
				return 0;
			}
		}
	}
}