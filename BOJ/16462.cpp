#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
double sum;
char arr[4];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf(" %s", arr);
		int x = 0;
		for (int j = 0; arr[j]; j++) {
			int y = arr[j] - '0';
			if (y == 0 || y == 6) y = 9;
			x = x * 10 + y;
		}
		if (x > 100) x = 100;
		sum += x;
	}
	sum /= n;
	printf("%.0lf", round(sum));
}