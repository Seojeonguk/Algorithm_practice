#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double r, c, t;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 1;; i++) {
		scanf("%lf %lf %lf", &r, &c, &t);
		if (!c) break;

		printf("Trip #%d: %.2lf %.2lf\n", i, r*c*3.14159 / 63360., r*c*3.14159*3600. / 63360. / t);
	}
}