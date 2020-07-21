#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int arr[5],x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &x, &arr[2]);
	x *= 1000,arr[2]*=1000;
	for (int i = 1; i <= 2; i++) {
		arr[2 - i] = arr[3 - i] / 2;
		arr[2 + i] = arr[1 + i] * 2;
	}

	int ans = 0;
	if (arr[4] + arr[3] + arr[2] <= x) ans = arr[4] + arr[3] + arr[2];
	else if (arr[3] + arr[2] + arr[1] <= x) ans = arr[3] + arr[2] + arr[1];
	else if(arr[2]+arr[1]+arr[0] <=x )ans = arr[2] + arr[1] + arr[0];
	printf("%d\n", ans);
}