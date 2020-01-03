#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double x, y;
pair<double, int> p[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) {
		scanf("%lf %lf", &y, &x);
		p[i].first = 10 * x / (y * 10 >= 5000 ? y * 10 - 500 : y * 10);
		p[i].second = i;
	} sort(p, p + 3);
	if (p[2].second == 0) puts("S");
	else if (p[2].second == 1) puts("N");
	else puts("U");
}