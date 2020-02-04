#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, arr[3],maxing[6], mining[6];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) scanf("%d", &arr[j]);
		maxing[3] = max(maxing[0] + arr[0], maxing[1] + arr[0]);
		maxing[4] = max(maxing[0] + arr[1], max(maxing[1] + arr[1], maxing[2] + arr[1]));
		maxing[5] = max(maxing[1] + arr[2], maxing[2] + arr[2]);

		mining[3] = min(mining[0] + arr[0], mining[1] + arr[0]);
		mining[4] = min(mining[0] + arr[1], min(mining[1] + arr[1], mining[2] + arr[1]));
		mining[5] = min(mining[1] + arr[2], mining[2] + arr[2]);

		maxing[0] = maxing[3];
		maxing[1] = maxing[4];
		maxing[2] = maxing[5];
		mining[0] = mining[3];
		mining[1] = mining[4];
		mining[2] = mining[5];
	}

	printf("%d %d\n", max(maxing[0], max(maxing[1], maxing[2])), min(mining[0], min(mining[1], mining[2])));
}