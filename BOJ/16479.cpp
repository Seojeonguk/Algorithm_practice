#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

double D1, D2, K;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf", &K);
	scanf("%lf %lf", &D1, &D2);
	double triangle_base = (D1 > D2 ? (D1 - D2) / 2 : (D2 - D1) / 2);
	triangle_base = pow(triangle_base, 2);
	K = pow(K, 2);

	printf("%lf", K - triangle_base);
}