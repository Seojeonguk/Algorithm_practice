#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int arr[6];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		for (int i = 0; i < 6; i++) scanf("%d", &arr[i]);
		sort(arr, arr + 6);
		if ((arr[0] == 0) && (arr[5] == 0)) break;


		int sum = arr[1] + arr[2] + arr[3] + arr[4];
		if (sum % 4 == 2) printf("%.1lf\n", (double)(sum / 4.0));
		else if ((sum % 4 == 1) || (sum % 4 == 3)) printf("%.2lf\n", (double)(sum / 4.0));
		else printf("%d\n", sum / 4);
	}
}