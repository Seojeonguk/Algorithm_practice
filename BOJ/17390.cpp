#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, q,l,r;
int arr[300004];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &q);

	for (int i = 1; i <= n; i++) scanf("%d", &arr[i]);
	
	sort(arr + 1, arr + n + 1);

	for (int i = 1; i <= n; i++)
		arr[i] += arr[i - 1];

	for (int i = 0; i < q; i++) {
		scanf("%d %d", &l, &r);
		printf("%d\n", arr[r] - arr[l-1]);
	}
}