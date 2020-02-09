#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int arr[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) scanf("%d", &arr[i]);
	sort(arr, arr + 3);
	int diff1 = arr[1] - arr[0], diff2 = arr[2] - arr[1];
	if (diff1 == diff2) printf("%d\n", arr[2] + diff1);
	else printf("%d\n", diff1 > diff2 ? arr[0] + diff2 : arr[1] + diff1);
}