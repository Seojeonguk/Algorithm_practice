#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, h, high,ans_min,ans_max;
char arr[10];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &h);
	ans_min = 2, ans_max = h - 1;
	for (int i = 0; i < n; i++) {
		scanf("%d %s", &high, arr);
		if (arr[0] == 'B') ans_max = min(ans_max, high - 1);
		else if (arr[0] == 'S') ans_min = max(ans_min, high + 1);
	}

	printf("%d %d\n", ans_min, ans_max);
}