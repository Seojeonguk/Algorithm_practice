#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int l, d, x;

int digit_of_sum(int x) {
	int ret = 0;
	while (x) {
		ret += x % 10;
		x /= 10;
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &l, &d, &x);

	for (int i = l; i <= d; i++) {
		if (digit_of_sum(i) == x) {
			printf("%d\n", i);
			break;
		}
	}
	for (int i = d; i >= l; i--) {
		if (digit_of_sum(i) == x) {
			printf("%d\n", i);
			break;
		}
	}
}