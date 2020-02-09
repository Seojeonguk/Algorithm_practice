#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

double e=1,tmp=1;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	puts("n e");
	puts("- -----------");
	for (double i = 0; i < 10; i++) {
		if (i) {
			tmp *= i;
			e += 1 / tmp;
		}
		if (i == 0) puts("0 1");
		else if (i == 1) puts("1 2");
		else if (i == 2) puts("2 2.5");
		else printf("%d %.9lf\n", int(i), e);
	}
}