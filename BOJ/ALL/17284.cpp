#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int arr[] = { 0,500,800,1000 },x,ans=5000;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &x) != -1)
		ans -= arr[x];

	printf("%d\n", ans);
}