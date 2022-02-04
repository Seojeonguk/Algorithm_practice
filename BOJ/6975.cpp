#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t,x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d", &x);
		int sum = 0;

		for (int i = 1; i < x; i++)
			if (x % i == 0) sum += i;

		if (sum > x) printf("%d is an abundant number.\n",x);
		else if (sum < x) printf("%d is a deficient number.\n",x);
		else printf("%d is a perfect number.\n",x);
		puts("");
	}
}