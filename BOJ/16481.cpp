#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

double r1, r2, r3;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf %lf %lf\n", &r1, &r2, &r3);

	printf("%lf\n", ((r1*r2*r3) / (r1*r2 + r2*r3 + r1*r3)));
}