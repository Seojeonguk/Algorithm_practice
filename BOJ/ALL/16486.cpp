#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double d1, d2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lf %lf", &d1, &d2);

	double tmp = d1 * 2;
	tmp += d2 * 2 * 3.141592;
	printf("%lf", tmp);
}