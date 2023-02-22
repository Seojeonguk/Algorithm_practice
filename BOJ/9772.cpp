#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

double x, y;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%lf %lf", &x, &y);

		if (x == 0 || y == 0) {
			puts("AXIS");
			if (x == 0 && y == 0)
				break;
		}
		else if (x > 0) {
			if (y > 0) puts("Q1");
			else puts("Q4");
		}
		else {
			if (y > 0) puts("Q2");
			else puts("Q3");
		}
	}
}
