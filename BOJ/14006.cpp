#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, arr[1 << 18];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < (1 << n); i++) scanf("%d", &arr[i]);
	int dudu = arr[0];
	sort(arr, arr + (1<<n));
	if (!n || arr[0] != dudu || arr[1] == dudu) puts("YES");
	else puts("NO");
}