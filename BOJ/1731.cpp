#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, arr[52];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	if (arr[2] - arr[1] == arr[1] - arr[0]) printf("%d\n", arr[n - 1] + arr[1] - arr[0]);
	else printf("%d\n", arr[n - 1] * (arr[1] / arr[0]));
}