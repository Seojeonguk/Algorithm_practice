#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, arr[1002];
int sum;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
	sort(arr, arr + n);
	
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);

	for (int i = 0; i < n; i++) {
		if (arr[i] > sum+1) break;
		sum += arr[i];
	}

	printf("%d", ++sum);
}