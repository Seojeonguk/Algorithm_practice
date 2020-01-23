#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m,ans;
int arr[1002];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) scanf("%d", &arr[i]);

	for (int i = 1; i <= n; i++)
		for (int j = 0; j < m; j++)
			if (i%arr[j] == 0) {
				ans += i;
				break;
			}

	printf("%d\n", ans);
}