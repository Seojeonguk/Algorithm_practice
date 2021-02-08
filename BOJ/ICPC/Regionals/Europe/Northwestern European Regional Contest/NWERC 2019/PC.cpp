#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long a;
#define M_PI 3.14159265358979323846

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld", &a);

	double d = sqrt(1. * a / M_PI);

	printf("%lf\n", 2 * d * M_PI);
}