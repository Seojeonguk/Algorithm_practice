#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%lf", &c);
		if (c == 0) break;
		double length = 0;
		for (int i = 2;; i++) {
			length += (1. / i);
			if (length >= c) {
				printf("%d card(s)\n", i-1);
				break;
			}
		}
	}
}