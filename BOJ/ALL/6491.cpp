#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if (!n) break;

		int sum = 0;
		for (int i = 1; i < n; i++)
			if (n % i == 0)
				sum += i;

		printf("%d ", n);
		if (sum > n) puts("ABUNDANT");
		else if (sum < n) puts("DEFICIENT");
		else puts("PERFECT");
	}
}