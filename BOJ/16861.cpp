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
	scanf("%d", &n);

	for (int i = n;; i++) {
		int tmp = i,sum=0;
		while (tmp) {
			sum += tmp % 10;
			tmp /= 10;
		}
		if (i%sum == 0) {
			printf("%d\n", i);
			break;
		}
	}
}