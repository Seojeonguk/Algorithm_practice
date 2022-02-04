#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, b;
double p;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %lf", &b, &p);
		double a = 60 / p;

		printf("%.4lf %.4lf %.4lf\n", (b - 1) * a, b * a, (b + 1) * a);
	}
}