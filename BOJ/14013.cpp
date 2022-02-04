#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double a, b, tmp,z;
char q;
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf %lf %d", &a, &b,&n);
	for (int i = 0; i < n; i++) {
		scanf("%lf %c", &z, &q);
		if (z == 0) {
			puts("0.0000");
			continue;
		}
		printf("%lf\n", q == 'A' ? b * z / a : a * z / b);
	}
}