#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, num;
double d, a, b, f;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d %lf %lf %lf %lf", &num, &d, &a, &b, &f);
		printf("%d %.4lf\n", num, d*f / (a + b));
	}
}